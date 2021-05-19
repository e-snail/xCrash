package lib.base.xcrash;


/**
 * Define the logger interface used by xCrash.
 */
public interface ILogger {

    /**
     * Log a VERBOSE message.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @SuppressWarnings("unused")
    void v(String tag, String msg);

    /**
     * Log a VERBOSE message and the exception.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @SuppressWarnings("unused")
    void v(String tag, String msg, Throwable tr);

    /**
     * Log a DEBUG message.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @SuppressWarnings("unused")
    void d(String tag, String msg);

    /**
     * Log a DEBUG message and the exception.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @SuppressWarnings("unused")
    void d(String tag, String msg, Throwable tr);

    /**
     * Log a INFO message.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @SuppressWarnings("unused")
    void i(String tag, String msg);

    /**
     * Log a INFO message and the exception.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @SuppressWarnings("unused")
    void i(String tag, String msg, Throwable tr);

    /**
     * Log a WARN message.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @SuppressWarnings("unused")
    void w(String tag, String msg);

    /**
     * Log a WARN message and the exception.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @SuppressWarnings("unused")
    void w(String tag, String msg, Throwable tr);

    /**
     * Log a ERROR message.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @SuppressWarnings("unused")
    void e(String tag, String msg);

    /**
     * Log a ERROR message and the exception.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @SuppressWarnings("unused")
    void e(String tag, String msg, Throwable tr);
}
