// 在堆区开辟空间 实现单链表的创建 ，遍历，查找，增加，删除
#include <iostream>
#include<malloc.h>
using namespace std;

/*
   链表格式
      head --->1 ---->2 ----->3 ----->4 ----->NULL; 
*/

typedef struct Node{
	int id;
	Node *next;
	
}Node;


// 初始化单链表
Node* initList(){
	Node *head = (Node*)malloc(sizeof(Node));

	if(head == NULL){
		cout<<"堆区分配内存失败，无法创建链表"<< endl;
		return NULL; 
	}
	head->id = -1;  // -1表示为 链表头 
	head->next = NULL;  // 初始化 
	return head; 
		
} 

// 创建单链表  -- 接受用户赋值，用户输入-1 结束单链表创建 
void createList(Node *head){
	if(head ==NULL);
	Node* pCur = head;
	while(1){
		Node *pNew = (Node*)malloc(sizeof(Node));
		cout<<"请输入值_"<<endl;
		cin>> pNew->id;
		if(pNew->id == -1){
			break;
		} 
		pCur->next = pNew;
		pNew->next = NULL; //  
		pCur = pNew;			
	}	
}

// 查找指定节点
Node* findNodeByValue(Node *head,int value){
	Node* pCur = head->next;
	int flag = 0;
	while(pCur != NULL){
		if(pCur->id == value){
			flag = 1;
			break;
		}
		pCur = pCur->next;		
	}
	if(flag) {
		return pCur;
	}else{
		return NULL;
	}
		
	
} 

// 插入节点 在 指定元素之前 ，如果指定元素不存在 直接在链表尾部插入
void insertBeforeValue(Node*head,int value,int newValue){
	Node* pPre = head;
	Node* pCur = head->next;
	while(pCur != NULL){  // 没有找到的话  跳出循环，pCur 为空，pPre 为最后一个元素 
		if(pCur->id == value){
			break;			
		}
		pPre = pCur;  // 保存先前的
		pCur = pCur->next;	  // 保存的下一个   // 插入就在中间	 
	}
	//生成新的节点
	Node* pNew = (Node*)malloc(sizeof(Node));
	pNew->id = newValue;
	pNew->next = NULL;
	
	pPre->next = pNew;
	pNew->next = pCur;	
} 

// 删除指定节点
void deleteNodeByValue(Node* head,int value){
	Node* pPre = head;
	Node* pCur = head->next;
	int flag = 0;
	while(pCur!=NULL){
		if(pCur->id == value){
			pPre->next = pCur->next;
			free(pCur);
			pCur = NULL;
			flag = 1;
			break;
		}
		pPre = pCur;
		pCur = pCur->next;			
	}
		if(flag){
			cout<<"已经删除"<<value<<endl; 			  	
		}else{
			cout<<"不存在该节点"<<endl; 
		}	
} 
 
  
  // 遍历链表
void displayList(Node *head){
	Node* pCur = head->next;
	while(pCur != NULL){
		cout<<pCur->id<<endl;	
		pCur = pCur->next;	
	}	
}

int main(int argc, char** argv)
{
	
	cout<<"hello world"<<endl;
	Node* head = initList();
	createList(head);

	//cout<<"所查找的节点"<<findNodeByValue(head,99)->id<<endl;
	insertBeforeValue(head,4,100);
	deleteNodeByValue(head,5);
	displayList(head);
	
	
	return 0;
}















