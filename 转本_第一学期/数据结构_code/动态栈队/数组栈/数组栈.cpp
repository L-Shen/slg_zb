#include <iostream>
#include<malloc.h>
#define MAX_SIZE 10
using namespace std;

// 栈的规则是 先进后出 ，
/*
  入栈顺序是 1 2 3 4
  那么 4 就是栈头， 1 就是栈底 
  那么出栈顺序就是 4 3 2 1 
  
*/ 

// 顺序栈  即为数组实现栈的规则
typedef struct arrayStack{
	int* arr;
	int top;
	int count;
	
}STACK,*PSTACK;

// 检查栈是否满
bool isStackFull(PSTACK S){
	if(S->count==MAX_SIZE)return true;// 栈满
	return false; 
	
}

// 初始栈
void initStack(PSTACK S){
	S->arr = (int*)malloc(sizeof(int)*MAX_SIZE);
	S->top = -1;
	S->count = 0;	
} 

// 栈中增加元素 
void push(PSTACK S,int value){
	//检测栈是否满
	if(isStackFull(S)) {
		cout<<"当前栈已经满了"<<endl;
		return;
	} 
	S->arr[++S->top] = value;
	S->count++;
}

// 出栈
int pop(PSTACK S){
	if(S->count == 0) {
		cout<<"栈里面没有元素"<<endl;
		return -1; 		
	}
	int popValue = S->arr[S->top--];
	S->count--;
	return popValue;	
}

 

int main(int argc, char** argv)
{
	PSTACK S = (PSTACK)malloc(sizeof(STACK)*MAX_SIZE);
	initStack(S);
	
	
	cout<<pop(S)<<endl; 
	
	return 0;
}
 