 #include <iostream>
 #include<malloc.h>
 using namespace std;
 
 /*
 数组实现的是 顺序栈，缺点是 元素固定，
 链式栈通过 链表的方式来实现，不存在元素个数固定，元素不会满的
 链表的特点是：数据域和指针域 
 
   top [ 标志位]
    |
  元素2
    |
  元素1	
  	    
 */
 typedef struct LinkStackNode
 {
	 int id;
	 LinkStackNode *next;  
 } LStackNode,*LStack;
 
  // 检测栈是否为空栈
 bool isEmptyStack(LStack top){
 	if(top->next == NULL){
		 cout<<"当前栈为空"<<endl;
		 return true; 
	 }
	 return false;	 
 }
 
 // 初始化链式栈 即为定义栈头
 void init_LStack(LStack top){
 	if(top==NULL){
		 return;
	 }
 	top->id = -1;  // 栈头
	top->next = NULL; 	 
	cout<<"栈头开辟成功"<<top->id<<endl;
 } 
 
 // 入栈
 void pushStack(LStack top,int value){
 	// 入栈元素
 
	 LStack pNew = (LStack)malloc(sizeof(LStackNode)); 
	 pNew->id = value;
	 pNew->next = top->next;  
	 top->next = pNew;	 
 }
 
 // 出栈
 void popStack(LStack top){
     if(isEmptyStack(top)){
     	cout<<"栈空没有元素 程序终止"<<endl;
		 return ;
	 } 
	 LStack p = top->next;
	 top->next = p->next;
	 cout<<"出栈元素为->"<<p->id<<endl;
	 free(p);  // 干掉出栈元素 
	 p = NULL; 	 
 } 
 
 // 获取栈顶元素  只显示 不释放 
 int getForntValue(LStack top){
 	if(isEmptyStack(top)){
		 exit(-1); // 栈为空 终止  
	 }
	 return top->next->id;
	 
 } 
 
 // 获取栈节点个数 不包括栈头
 int getStackCount(LStack top){
 	int count = 0;
 	LStack p = top->next;
 	while(p!=NULL){
 		count++;
 		p = p->next;		 
	 }
	return count;	 
 } 
 
 // 释放栈 即为 栈头和节点全部干掉 
 void freeStackAllNode(LStack top){
 	LStack p,q;
 	p = top;
 	while(!p){  //  
		 q = p;
	 	 p = p->next;
	 	 free(q);	 	  
	 }
	 cout<<"整个栈释放完了 bye!!"<<endl;
	 
 } 
 
 
 
 int main(int argc, char** argv)
 {
 	 LStack top = (LStack)malloc(sizeof(LStackNode));
 	 init_LStack(top);  //初始化栈头 
	  	 
     // 入栈 
     pushStack(top,1);
	 pushStack(top,2); 
     pushStack(top,3);
     
     
     cout<<"当前栈顶为->"<<getForntValue(top)<<endl; 
     cout<<"当前栈节点个数->"<<getStackCount(top)<<endl; 
	    
	 popStack(top);  //出栈  3 
	 popStack(top);  // 2 
	 popStack(top);  // 1
	 
	 freeStackAllNode(top);
	 
	 
	 
	 
	 
	 
	 return 0;
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  
  