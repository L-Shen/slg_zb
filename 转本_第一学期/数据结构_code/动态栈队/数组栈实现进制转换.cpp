// 数值转换器 数组栈实现
// 队实现 即为 数组队 front = rear = 0; 
#include<iostream>
using namespace std;


constexpr auto M = 20;;
typedef struct BinaryStack {
	//int data[M]; // 这是一个静态数组 不许要人工开辟空间
	int *data;
	int top;
}*pStack;


void initStack(pStack pStack) {
	pStack->top = -1;
	cout << "栈初始化完毕" << endl;
}
// 栈满检测
bool fullStack(pStack pStack) {
	if (pStack->top == M - 1) {
		cout << "栈已满" << endl;
		return true;
	}
	return false;
}

//栈空检测
bool emptyStack(pStack pStack) {
	if (pStack->top == -1) {
		cout << "栈空状态" << endl;
		return true;
	}
	return false;
}

// 入栈
void pushStack(pStack pStack,int value){
	if (fullStack(pStack)) return;
	pStack->data[++pStack->top] = value;
}

// 出栈
void popStack(pStack pStack) {
	if (emptyStack(pStack))return;
	cout << "当前出栈元素为--->" << pStack->data[pStack->top--] << endl;
}

// 进制转换函数
void BinTrans(int n) {
	//初始化栈
	pStack pStack = (BinaryStack *)malloc(sizeof(BinaryStack));	
	pStack->data = (int*)malloc(sizeof(int)*M);
	initStack(pStack);
	// 入栈
	while (n)
	{
		pushStack(pStack, n % 2);
		n = n / 2;
	}
	while (!emptyStack(pStack))
	{
		popStack(pStack);
	}
}

int main() {
	BinTrans(100);
	system("pause");
	return 0;
}
