/*
Read N Characters Given Read4 II - Call multiple times /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Hide Company Tags Google Facebook
Hide Tags String
Hide Similar Problems (E) Read N Characters Given Read4
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    private int oneRead = 0;
    private int offset = 0;
    public int read(char[] buf, int n) {
         boolean lessthan4 = false;
         int haveRead = 0;
         while (!lessthan4 && haveRead < n) {
              if (oneRead == 0) {
                  oneRead = read4(buffer);
                  lessthan4 = oneRead < 4;
              }
              int actRead = Math.min(n-haveRead, oneRead);
              for (int i=0; i<actRead; i++) {
                  buf[haveRead+i] = buffer[offset+i];
              }
              oneRead -= actRead;
              offset = (offset + actRead) % 4;
              haveRead += actRead;
          }
          return haveRead;
      }
    
}
