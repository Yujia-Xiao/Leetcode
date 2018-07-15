/*
302. Smallest Rectangle Enclosing Black Pixels  QuestionEditorial Solution  My Submissions
Total Accepted: 6299
Total Submissions: 15503
Difficulty: Hard
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Hide Company Tags Google
Hide Tags Binary Search


*/
public int minArea(char[][] image, int x, int y) {
    int m = image.length, n = image[0].length;
    int colMin = binarySearch(image, true, 0, y, 0, m, true);
    int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
    int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
    int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
    return (rowMax - rowMin) * (colMax - colMin);
}

public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
    while(lower < upper) {
        int mid = lower + (upper - lower) / 2;
        boolean inside = false;
        for(int i = min; i < max; i++) {
            if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                inside = true; 
                break;
            }
        }
        if(inside == goLower) {
            upper = mid;
        } else {
            lower = mid + 1;
        }
    }
    return lower;
}

