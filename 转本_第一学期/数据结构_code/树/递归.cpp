#include<iostream>
#include<malloc.h>
using namespace std;
// 编码

/*
  ��ʽջ�ı��廹������

<<<<<<< .mine

/*
递归:就是自己调用自己 也就是在某个方法中调用自己
递归中必须有跳出条件 ，否则 就是无限递归 等同于死循环 
||||||| .r27
/*
递归:就是自己调用自己 也就是在某个方法中调用自己
递归中必须有跳出条件 ，否则 就是无限递归 等同于死循环 
=======
  ��ʽջֻ��������ջ����ջβ

  top
  5
  4
  3
  2
  1
  bottom
>>>>>>> .r41
*/

typedef struct node {
	int id;
	struct node * next;
}NODE,*PNODE;

typedef struct stack {
	PNODE top; // ջ��
	PNODE bottom; // ջβ
}STACK,*PSTACK;



// ��ʼ��ջ
void init(PSTACK s) {
	s->top = s->bottom;
	s->top->next = NULL;
	cout << "init_stack_link complete" << endl;
}

// ���ջ�Ƿ�Ϊ��
bool empty(PSTACK s) {
	if (s->top == s->bottom) return false;
	return true;
}


// ��ջ
bool push(PSTACK s, int val) {
	// ���ջ�Ƿ���
	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	pNew->next = s->top;
	s->top = pNew;
	return true;
}

// ��ջ
void pop(PSTACK s,int *val) {
	if (!empty(s)) {
		PNODE q = s->top;
		*val = s->top->id;
		s->top = q->next;		
	}
}



// ����


int main() {
	PSTACK s = (PSTACK)malloc(sizeof(STACK) * 100);
	int val = 0;
	init(s);
	push(s, 1);
	push(s, 2);
	push(s, 3);
	push(s, 4);
	push(s, 5);

	pop(s, &val);
	cout << val;
	
	



}