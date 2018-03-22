#include <iostream>
#include <cstring>
using namespace std;

bool Increment(char *number);
void PrintNumber(char * number);
void PrintOneToMaxOfNdDigits(int n);

void RecursiveImplementation(int n);
void Recursively(char * number,int n,int index);

int main() {
    cout << "Please select the mode:" <<endl;
    cout << "0 -- Cyclic implementation" << endl;
    cout << "1 -- Recursive implementation" << endl;
    int N,mode;
    cin>>mode;
    cout << "Please input N:" << endl;
    cin>>N;

    if(mode == 1){
        RecursiveImplementation(N);
    }else{
        PrintOneToMaxOfNdDigits(N);
    }

    return 0;
}
/**
 * @Description: 递增字符串number中的数，并判断根据最高位是否溢出判断是否遍历完成
 * @param number 储存数各个位的字符串
 * @return false:未遍历完成  true:遍历结束
 */
bool Increment(char *number)
{
    int length  =strlen(number);
    int nTakeOver = 0;
    bool OverFlow = false;
    for (int i = length-1; i >= 0; --i) {
        int nSum = number[i] - '0' + nTakeOver;
        if(i == length -1){
            nSum++;
        }
        if(nSum>9){
            if(i == 0){
                OverFlow = true;
            } else{
                nSum -= 10;
                nTakeOver = 1;
                number[i] = '0' + nSum;
            }
        }else{
            number[i] = '0'+nSum;
            break;
        }
    }
    return OverFlow;
}

/**
 * @Description: 从第一个非0项开始打印字符串
 * @param number
 */
void PrintNumber(char * number)
{
    int length = strlen(number);
    bool isZeros = true;
    for (int i = 0; i < length; ++i) {
        if(isZeros && (number[i] != '0')){
            isZeros = false;
        }
        if(!isZeros){
            cout<<number[i];
        }
    }
    cout<<" ";

}

/**
 * @Description: 循环方式实现
 * @param n
 */
void PrintOneToMaxOfNdDigits(int n)
{
    if(n<0){
        return;
    }

    char *number = new char[n+1];
    memset(number,'0',n);
    number[n] = '\0';

    while(! Increment(number))
    {
        PrintNumber(number);
    }
    delete[] number;
}

/**
 * @Description: 递归方式实现
 * @param: n 输入的最大位数
 */
void RecursiveImplementation(int n)
{
    if(n<=0){
        cout<<"The input N is mistaken!"<<endl;
        return;
    }

    char *number = new char[n+1];
    memset(number,'0',n);
    number[n] = '\0';

    Recursively(number,n,0);


}

void Recursively(char * number,int n,int index)
{
    if(index == n){
        PrintNumber(number);
        return;
    }
    for (int i = 0; i < 10; ++i) {
        number[index] = i+'0';
        Recursively(number,n,index+1);
    }
}