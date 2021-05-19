package lib.base.xcrash;


/**
 * The errno code for init() method of {@link xcrash.XCrash}.
 */
@SuppressWarnings("WeakerAccess")
public final class Errno {

    /**
     * Initialization successful.
     */
    public static final int OK = 0;

    /**
     * The context parameter is null.
     */
    public static final int CONTEXT_IS_NULL = -1;

    /**
     * Load xCrash's native library failed.
     */
    public static final int LOAD_LIBRARY_FAILED = -2;

    /**
     * Initialize xCrash's native library failed.
     */
    public static final int INIT_LIBRARY_FAILED = -3;

    private Errno() {
    }
}
