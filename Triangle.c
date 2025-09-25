int minimumTotal(int** triangle, int triangleSize, int* triangleColSize) {
    int *dp = (int*)malloc(sizeof(int)*triangleColSize[triangleSize-1]);
    for(int i = 0; i < triangleColSize[triangleSize-1] ; i++){
            dp[i] = triangle[triangleSize-1][i];                               // We create an array of the last row values. We move from bottom to top, so we store bottom values first here
    }

    for(int i = triangleSize-2;i>=0;i--){
        for(int j = 0;j < triangleColSize[i];j++){
            dp[j] = triangle[i][j] + (dp[j]>dp[j+1]?dp[j+1]:dp[j]);             // Here we take the minimum of the 2 previous values and add it to the value of an above column that is adjacent to them both, store it 
        }                                                                       // back in the dp array of the ith index of the above column(the one adjacent to both. This way we slowly shorten the array
    }                                                                           // (as its a triangle, so it shortens as we move to the top, till we reach the last value of top, which gets updated in dp[0]. 
    int result = dp[0];
    free(dp);
    return result;
}
