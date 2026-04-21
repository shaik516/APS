class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        // Edge case: no change needed
        if (original == color) return image;

        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int original, int color) {
        // Boundary + color check
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != original) {
            return;
        }

        // Fill color
        image[i][j] = color;

        // 4-directional DFS
        dfs(image, i + 1, j, original, color);
        dfs(image, i - 1, j, original, color);
        dfs(image, i, j + 1, original, color);
        dfs(image, i, j - 1, original, color);
    }
}