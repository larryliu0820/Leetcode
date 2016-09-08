import javax.smartcardio.CommandAPDU;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Valued Customer on 9/8/2016.
 * 359. Logger Rate Limiter
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if
 * and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given
 timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.

 Example:

 Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "bar" at timestamp 2
 logger.shouldPrintMessage(2,"bar"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "bar" at timestamp 8
 logger.shouldPrintMessage(8,"bar"); returns false;

 // logging string "foo" at timestamp 10
 logger.shouldPrintMessage(10,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class p359 {
    /** Initialize your data structure here. */
    class Log {
        int timestamp;
        String message;
        public Log(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
    Queue<Log> q;
    public p359() {
        q = new LinkedList<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Log log = new Log(timestamp, message);
        while (!q.isEmpty() && (q.peek().timestamp + 10) <= timestamp) q.poll();
        for (Log l : q) {
            if (l.message.equals(message)) return false;
        }
        q.offer(log);
        return true;
    }
}
