//#include <iostream>
#include <stdio.h>
#include <string.h>

#define MAXN 1001
#define MINH -10001

//typedef H * Heap;
//struct H{
//    int parent;
//    int data;
//    Heap Left,Right;
//};
int H[MAXN],size;

void Create(){
    size = 0;
    H[0] = MINH;
}

void Insert(int X){
    int i;
    size += 1;
    for (i = size; H[i/2] > X;i = i/2) {
        H[i] = H[i/2];
    }
    H[i] = X;
}

int main() {

    int M,N;
    int data,target;
    scanf("%d %d",&N,&M);
    Create();
    for (int i = 0; i < N; ++i) {
        scanf("%d",&data);
        Insert(data);
    }
    for (int j = 0; j < M; ++j) {
        scanf("%d",&target);
        printf("%d",H[target]);
        target =  target/2;
        while(target>0){
            printf(" %d",H[target]);
            target =  target/2;
        }
        printf("\n");
    }
    return 0;
}