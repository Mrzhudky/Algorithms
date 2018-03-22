//
// Created by zhu on 2017/11/5.
//
//#include <iostream>

#include <stdio.h>
#include <stdlib.h>
typedef struct Node *List;
struct Node{
    long lastAddr;
    long nextAddr;
    int data;
    List link;
};
List Reverse(List L,long K,long N);
List Read(long N)
{
    List head= (List)malloc(sizeof(struct Node));
    head->link = NULL;
    List rear = head;
    for (int i = 0; i < N; ++i) {
        List temp = (List)malloc(sizeof(struct Node));
        scanf("%d %d %d",&temp->lastAddr,&temp->data,&temp->nextAddr);
        temp->link = NULL;
        rear->link = temp;
        rear = temp;
    }
    List front = head;
    head = front->link;
    free(front);
    return head;
}
List Sort(List L,long N,long K,long startAddr)
{
    List front = (List)malloc(sizeof(struct Node));
    front->link = NULL;
    front->nextAddr = 0;
    List rear =front;
    long n = 0;
    long addr = startAddr;
    while (n<N) {
        List t1 =NULL,t2 = L;
        while (t2) {
            if (t2->lastAddr == addr) {
                rear->link = t2;
                rear = t2;
                List temp = t2->link;
                //t2->link = NULL;
                if (t1) {
                    t1->link = temp;
                }else{
                    L = temp;
                }
                t2->link = NULL;
                n++;
                addr = rear->nextAddr;
                break;
            }
            t1 = t2;
            t2 = t2->link;
        }
        if(rear->nextAddr == -1){
            break;
        }
    }
    List f = front;
    front = f->link;
    free(f);
    List head = Reverse(front,K,n);
    return head;
}

void Print(List L) {
    while (L){
        if(L->nextAddr == -1){
            printf("%.5d %d %d\n",L->lastAddr,L->data,L->nextAddr );
            return;
        }else {
            printf("%.5d %d %.5d\n", L->lastAddr, L->data, L->nextAddr);
            L = L->link;
        }
    }
    return;
}
List Reverse(List L,long K,long N){
    int times =0,remainder =0;
    times = N/K;
    remainder = N%K;

    List head = (List)malloc(sizeof(struct Node));
    head->link = NULL;
    List l1 = NULL,l2 = head,l3 = head;
     for(int j=0;j<times;j++){
         for (int i = 0; i < K; ++i) {
             if(L == NULL){
                 break;
             }
             List temp = L->link;
             L->link = l1;
             if(l1){
                 L->nextAddr = l1->lastAddr;
             }else{
                 L->nextAddr = -1;
             }
             l1 = L;
             L = temp;
             if(i == 0){
                 l3 = l1;

             }
         }
         l2->link =l1;
         l2->nextAddr =l1->lastAddr;
         l2 = l3;
         l1 = NULL;
     }
    for (int k = 0; k < remainder; ++k) {
        l2->link = L;
        l2->nextAddr = L->lastAddr;
        l2 = L;
        L = L->link;
    }
    List h = head;
    head = h->link;
    free(h);
    return head;
}

int main() {
    long startAddr =0;
    long N = 0;
    long K =0;
    scanf("%d %d %d",&startAddr,&N,&K);
    List inputList,outputList;
    inputList = Read(N);
    outputList = Sort(inputList,N,K,startAddr);
    // = Reverse(inputList,K);
    Print(outputList);
    //Print(inputList);
    return 0;
}