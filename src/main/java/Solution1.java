import java.util.Stack;

class Solution1 implements Solution {
    @Override
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        if (nr == 0) {
            return 0;
        }
        int nc = grid[0].length;
        int[] visit = new int[nr*nc];

        int count = 0;
        for (int i = 0; i < nr*nc; i++) {
            if (visit[i] == 0 && grid[i/nc][i%nc] == '1') {
                count++;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int curr = stack.pop();
                    visit[curr] = 1;
                    if (curr > nc && visit[curr-nc] == 0 && grid[(curr-nc)/nc][(curr-nc)%nc] == '1') {
                        stack.push(curr-nc);
                    }
                    if (curr+nc < nr*nc && visit[curr+nc] == 0 && grid[(curr+nc)/nc][(curr+nc)%nc] == '1') {
                        stack.push(curr+nc);
                    }
                    if (curr%nc != 0 && visit[curr-1] == 0 && grid[(curr-1)/nc][(curr-1)%nc] == '1') {
                        stack.push(curr-1);
                    }
                    if (curr%nc != nc-1 && visit[curr+1] == 0 && grid[(curr+1)/nc][(curr+1)%nc] == '1') {
                        stack.push(curr+1);
                    }
                }
            } else if (visit[i] == 0) {
                visit[i] = 1;
            }
        }

        return count;
    }
}