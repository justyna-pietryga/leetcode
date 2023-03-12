/**
 09-Jan-2023
 <a href="https://leetcode.com/problems/first-bad-version">...</a>
 */

public class BadVersion {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int i = n / 2 + 1;

        while (start < end) {
            if (isBadVersion(i)) {
                end = i;
            } else {
                start = i + 1;
            }
            i = start + (end - start) / 2;
        }

        return i;
    }

    /**
     *Can someone please explain to me why sometimes we use the terminating condition while(start<end) while some other times we use while(start<=end) .
     * I am not able to grok this thing and it causes too much confusion and frustration.
     * An explanation to this would be very highly appreciated. Thank you!
     * If you're looking for something specifically inside the array and will return it as soon as you find it (inside the while loop), you'll want to use start <= end.version
     * If you're you're moving the pointer value to find the least or greatest of something, then use start < end.
     */

    public boolean isBadVersion(int version) {
        return true;
    }
}
