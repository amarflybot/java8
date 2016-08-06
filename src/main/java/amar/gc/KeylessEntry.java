package amar.gc;

/**
 * Created by kumarao on 06-08-2016.
 */
class KeylessEntry {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
