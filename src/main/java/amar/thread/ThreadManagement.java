package amar.thread;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.management.LockInfo;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import static java.lang.management.ManagementFactory.getThreadMXBean;

/**
 * Created by kumarao on 19-01-2016.
 */
public class ThreadManagement {

    private static String INDENT = "    ";

    public static String detectDeadlocks() {
        ThreadMXBean threadBean = getThreadMXBean();
        long[] tids;
        if ((tids = threadBean.findDeadlockedThreads()) != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos, true);
            ps.print("DEADLOCK DETECTED! threads are ");
            for (long tid : tids) {
                ps.print(tid);
                ps.print(", ");
            }
            ps.println();
            dumpThreadInfoWithLocks(threadBean, ps);
            ps.println();
            ps.close();
            return new String(baos.toByteArray());
        }
        return null;
    }

    public static void dumpThreadInfoWithLocks(ThreadMXBean threadBean, PrintStream out) {
        out.println("Full Java thread dump with locks info");
        ThreadInfo[] tinfos = threadBean.dumpAllThreads(true, true);
        for (ThreadInfo ti : tinfos) {
            printThreadInfo(ti, out);
        }
        out.println();
    }

    public static void printThreadInfo(ThreadInfo ti, PrintStream out) {
        // print thread information
        printThread(ti, out);
        // print stack trace with locks
        StackTraceElement[] stacktrace = ti.getStackTrace();
        MonitorInfo[] monitors = ti.getLockedMonitors();
        for (int i = 0; i < stacktrace.length; i++) {
            StackTraceElement ste = stacktrace[i];
            out.println(INDENT + "at " + ste.toString());
            for (MonitorInfo mi : monitors) {
                if (mi.getLockedStackDepth() == i) {
                    out.println(INDENT + "  - locked " + mi);
                }
            }
        }
        LockInfo[] syncs = ti.getLockedSynchronizers();
        printLockInfo(syncs, out);
        out.println();
    }

    private static void printThread(ThreadInfo ti, PrintStream out) {
        StringBuilder sb = new StringBuilder("\"" + ti.getThreadName() + "\"" + " ID="
                + ti.getThreadId() + " in " + ti.getThreadState());
        if (ti.getLockName() != null) sb.append(" on lock=").append(ti.getLockName());
        if (ti.isSuspended()) sb.append(" (suspended)");
        if (ti.isInNative()) sb.append(" (running in native)");
        if (ti.getLockOwnerName() != null) {
            sb.append(" owned by ").append(ti.getLockOwnerName()).append(" ID=").append(ti.getLockOwnerId());
        }
        out.println(sb.toString());
    }

    private static void printLockInfo(LockInfo[] locks, PrintStream out) {
        if (locks.length == 0) return;
        out.println(INDENT + "Locked synchronizers: count = " + locks.length);
        for (LockInfo li : locks) {
            out.println(INDENT + "  - " + li);
        }
        out.println();
    }
}
