
class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
                if(rooms[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0];
            int j= temp[1];
            if(rooms[i][j] == 0) {
                //gate add others
                if(i - 1 >=0 && rooms[i-1][j] == 2147483647) {
                    rooms[i-1][j] = 1;
                    queue.add(new int[]{i-1,j});
                }

                if(j - 1 >=0 && rooms[i][j-1] == 2147483647) {
                    rooms[i][j-1] = 1;
                    queue.add(new int[]{i,j-1});
                }

                if(i + 1 < rooms.length && rooms[i+1][j] == 2147483647) {
                    rooms[i+1][j] = 1;
                    queue.add(new int[]{i+1,j});
                }

                if(j + 1 < rooms[0].length && rooms[i][j+1] == 2147483647) {
                    rooms[i][j+1] = 1;
                    queue.add(new int[]{i,j+1});
                }
            } else {
                if(i - 1 >=0 && rooms[i-1][j] != -1 && rooms[i-1][j] != 0 && rooms[i-1][j] == 2147483647 ) {
                    rooms[i-1][j] = rooms[i][j]+1;
                    queue.add(new int[]{i-1,j});
                }

                if(j - 1 >=0 && rooms[i][j-1] != -1 && rooms[i][j-1] != 0 && rooms[i][j-1] == 2147483647) {
                    rooms[i][j-1] = rooms[i][j]+1;
                    queue.add(new int[]{i,j-1});
                }

                if(i + 1 < rooms.length && rooms[i+1][j] != -1 && rooms[i+1][j] != 0 && rooms[i+1][j] == 2147483647) {
                    rooms[i+1][j] = rooms[i][j]+1;
                    queue.add(new int[]{i+1,j});
                }

                if(j + 1 < rooms[0].length && rooms[i][j+1] != -1 && rooms[i][j+1] != 0 && rooms[i][j+1] == 2147483647) {
                    rooms[i][j+1] = rooms[i][j]+1;
                    queue.add(new int[]{i,j+1});
                }
            }
        }
    }
}