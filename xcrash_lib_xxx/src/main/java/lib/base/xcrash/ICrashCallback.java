package lib.base.xcrash;


/**
 * Define the callback interface after the crash occurs.
 *
 * <p>Note: Strictly speaking, this interface should always be implemented.
 * When disk is exhausted, the crash information cannot be saved to a crash log file.
 * The only way you can get the crash information is through the second parameter of onCrash() method.
 * Then you should parse and post the information immediately, because the APP process is crashing,
 * it will be killed by the system at any time.
 */
public interface ICrashCallback {

    /**
     * When a Java exception or native crash occurs, xCrash first captures and logs
     * the crash information to a crash log file and then calls this method.
     *
     * @param logPath Absolute path to the crash log file.
     * @param emergency A buffer that holds basic crash information when disk exhausted.
     * @throws Exception xCrash will catch and ignore any exception throw by this method.
     */
    @SuppressWarnings("unused")
    void onCrash(String logPath, String emergency) throws Exception;
}
