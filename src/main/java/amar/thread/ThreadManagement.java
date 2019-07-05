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

    /**
     * @return
     */
    public static String detectDeadlocks() {
        final ThreadMXBean threadBean = getThreadMXBean();
        final long[] tids;
        if ((tids = threadBean.findDeadlockedThreads()) != null) {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final PrintStream ps = new PrintStream(baos, true);
            ps.print("DEADLOCK DETECTED! threads are ");
            for (final long tid : tids) {
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

    public static void dumpThreadInfoWithLocks(final ThreadMXBean threadBean, final PrintStream out) {
        out.println("Full Java thread dump with locks info");
        final ThreadInfo[] tinfos = threadBean.dumpAllThreads(true, true);
        for (final ThreadInfo ti : tinfos) {
            printThreadInfo(ti, out);
        }
        out.println();
    }

    public static void printThreadInfo(final ThreadInfo ti, final PrintStream out) {
        // print thread information
        printThread(ti, out);
        // print stack trace with locks
        final StackTraceElement[] stacktrace = ti.getStackTrace();
        final MonitorInfo[] monitors = ti.getLockedMonitors();
        for (int i = 0; i < stacktrace.length; i++) {
            final StackTraceElement ste = stacktrace[i];
            out.println(INDENT + "at " + ste.toString());
            for (final MonitorInfo mi : monitors) {
                if (mi.getLockedStackDepth() == i) {
                    out.println(INDENT + "  - locked " + mi);
                }
            }
        }
        final LockInfo[] syncs = ti.getLockedSynchronizers();
        printLockInfo(syncs, out);
        out.println();
    }

    private static void printThread(final ThreadInfo ti, final PrintStream out) {
        final StringBuilder sb = new StringBuilder("\"" + ti.getThreadName() + "\"" + " ID="
                + ti.getThreadId() + " in " + ti.getThreadState());
        if (ti.getLockName() != null) sb.append(" on lock=").append(ti.getLockName());
        if (ti.isSuspended()) sb.append(" (suspended)");
        if (ti.isInNative()) sb.append(" (running in native)");
        if (ti.getLockOwnerName() != null) {
            sb.append(" owned by ").append(ti.getLockOwnerName()).append(" ID=").append(ti.getLockOwnerId());
        }
        out.println(sb.toString());
    }

    private static void printLockInfo(final LockInfo[] locks, final PrintStream out) {
        if (locks.length == 0) return;
        out.println(INDENT + "Locked synchronizers: count = " + locks.length);
        for (final LockInfo li : locks) {
            out.println(INDENT + "  - " + li);
        }
        out.println();
    }
}
