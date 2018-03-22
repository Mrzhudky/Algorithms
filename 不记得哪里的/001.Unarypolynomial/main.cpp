//
// Created by zhu on 2017/11/5.
//
//#include <iostream>

#include <stdio.h>
#include <stdlib.h>

typedef struct PolyNode *Polynomial;
struct PolyNode{
	int coef;
	int expon;
	Polynomial link;
};


Polynomial Read()
{
	int N, coe, exp;
	Polynomial rear;
	Polynomial head = (Polynomial)malloc(sizeof(struct PolyNode));
	head->coef = 0;
	head->expon = 0;
	head->link = NULL;
	rear = head;

	scanf("%d", &N);
	if (N <= 0){
		return head;
	}
	else{
		scanf("%d %d", &coe, &exp);
		head->coef = coe;
		head->expon = exp;
	}
	for (int i = 0; i < (N - 1); ++i) {
		scanf("%d %d", &coe, &exp);
		Polynomial P = (Polynomial)malloc(sizeof(struct PolyNode));
		P->coef = coe;
		P->expon = exp;
		P->link = NULL;
		rear->link = P;
		rear = P;
	}
	return head;
}

void Print(Polynomial P) {
    if (P == NULL){
        printf("%d %d",0,0);
    }else{
		printf("%d %d",P->coef,P->expon);
		P = P->link;
	}
	while (P){
		printf(" %d %d", P->coef, P->expon);
		P = P->link;
	}
	printf("\n");
	return;
}

void freeNode(Polynomial P)
{
	if (P)
	{
		if (P->link){
			freeNode(P->link);
		}
		free(P);
	}

}

Polynomial PolyAdd(Polynomial P1, Polynomial P2)
{
	Polynomial head, rear;
	int sum;
	rear = (Polynomial)malloc(sizeof(struct PolyNode));
	rear->link = NULL;
	head = rear;

	while (P1 && P2){
		if (P1->expon > P2->expon){
            if(P1->coef){
                Polynomial temp = (Polynomial)malloc(sizeof(struct PolyNode));
                temp->coef = P1->coef;
                temp->expon = P1->expon;
                temp->link = NULL;
                rear->link = temp;
                rear = temp;
            }
			P1 = P1->link;
		}else if (P1->expon == P2->expon){
			sum = P1->coef + P2->coef;
			if(sum){
				Polynomial temp = (Polynomial)malloc(sizeof(struct PolyNode));
				temp->coef = sum;
				temp->expon = P1->expon;
				temp->link = NULL;
				rear->link = temp;
				rear = temp;
			}
            P1 = P1->link;
            P2 = P2->link;
		}else if (P1->expon < P2->expon){
            if(P2->coef) {
                Polynomial temp = (Polynomial) malloc(sizeof(struct PolyNode));
                temp->coef = P2->coef;
                temp->expon = P2->expon;
                temp->link = NULL;
                rear->link = temp;
                rear = temp;
            }
			P2 = P2->link;
		}
	}
	while (P1){
        if(P1->coef) {
            Polynomial temp = (Polynomial) malloc(sizeof(struct PolyNode));
            temp->coef = P1->coef;
            temp->expon = P1->expon;
            temp->link = NULL;
            rear->link = temp;
            rear = temp;
        }
		P1 = P1->link;
	}
	while (P2){
        if(P2->coef) {
            Polynomial temp = (Polynomial) malloc(sizeof(struct PolyNode));
            temp->coef = P2->coef;
            temp->expon = P2->expon;
            temp->link = NULL;
            rear->link = temp;
            rear = temp;
        }
		P2 = P2->link;
	}
	rear->link = NULL;
	rear = head;
	head = head->link;
	free(rear);
	return head;
}

Polynomial Insert(Polynomial head,Polynomial node)
{
	Polynomial   P = head,rear = head;

    if(node->coef == 0){
        return head;
    }
	while(P){
		if (P->expon > node->expon){
            if (P->link && (P->link->expon < node->expon)) {
                Polynomial temp = P->link;
                P->link = node;
                node->link = temp;
                return head;
            }
		} else if(P->expon == node->expon){
			P->coef += node->coef;
            if(P->coef == 0){
                Polynomial temp = P->link;
                rear->link = temp;
                free(P);
            }
			return head;
		}
		rear = P;
		P = P->link;
	}
	rear->link = node;
	return head;
}

Polynomial PolyMultiply(Polynomial P1, Polynomial P2)
{
	Polynomial t1=P1,t2 = P2;

	Polynomial head = (Polynomial)malloc(sizeof(struct PolyNode));
	head->coef = 0;
	head->expon = -2000;
	head->link = NULL;

	while (t1){
		t2 = P2;
		while (t2){
			Polynomial temp = (Polynomial)malloc(sizeof(struct PolyNode));
			temp->coef = t1->coef * t2->coef;
			temp->expon = t1->expon + t2->expon;
			temp->link = NULL;
			head = Insert(head,temp);
			t2 = t2->link;
		}
		t1 = t1->link;
	}
    Polynomial h = head;
    head = h->link;
    free(h);
	return head;
}

int main()
{
	Polynomial P1, P2, PSum, PProduct;
	P1 = Read();
	P2 = Read();
	PSum = PolyAdd(P1, P2);
	PProduct = PolyMultiply(P1,P2);
	Print(PProduct);
	Print(PSum);

	freeNode(P1);
	freeNode(P2);
	freeNode(PSum);
	freeNode(PProduct);
	return 0;
}