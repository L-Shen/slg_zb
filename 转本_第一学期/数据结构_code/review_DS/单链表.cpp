#include<iostream>
#include<malloc.h>
using namespace std;
/*

  H-> A -> B-> C-> D-> E ->NULL
  -1->1->2->3->4->5->......->NULL


*/

struct LinkNode {
	int name;
	struct LinkNode *next;
};

// 创建链表头
LinkNode* creat_head_link(LinkNode *head) {
	head = (LinkNode *)malloc(sizeof(LinkNode));
	head->name = -1;
	head->next = NULL;
	return head;
}
// 初始化链表
void init_link(LinkNode *head) {
	for (int i = 1;i <= 10;i++) {
		LinkNode *pNew = (LinkNode *)malloc(sizeof(LinkNode));
		pNew->name = i;
		pNew->next = NULL;
		head->next = pNew;
		head = pNew;
	}
}

// 遍历链表
void display_link(LinkNode *head) {
	cout << "链表头为" << head->name << endl;
	LinkNode *curNode = head->next;
	while (curNode!=NULL) {
		cout << curNode->name << endl;
		curNode = curNode->next;
	}
}

// 插入节点 指定元素之前 没有指定元素 直接尾部插入
void insert_value(LinkNode *head,int name,LinkNode *insertNode) {
	// 
	LinkNode *preNode = head;
	LinkNode *curNode = head->next;
	while(curNode!=NULL){
		if (curNode->name == name) {
			break;
		}
		preNode = curNode;//顺序不能颠倒
		curNode = curNode->next;
	}
	preNode->next = insertNode;
	insertNode->next = curNode;
}

// 删除节点
void delete_node_by_name(LinkNode *head,int name) {
	//找节点
	LinkNode *preNode = head;
	LinkNode *curNode = head->next;
	bool flag = false;
	while (curNode!=NULL)
	{
		if (curNode->name == name) {
			flag = true;
			break;
		}
		preNode = curNode;
		curNode = curNode->next;
	}
	if (flag) {
		preNode->next = curNode->next;
		free(curNode);
		curNode = NULL;
		cout << "删除完毕" << endl;
	}
	else {
		cout << "没有该" << name << "的节点信息" << endl;
	}
}

// 查找节点通过 name
void findNodeByName(LinkNode *head,int name) {
	LinkNode *curNode = head->next;
	while (curNode!=NULL) {
		if (curNode->name == name) {
			cout << "已经找到" << endl;
			cout << "所查找的节点的下一个节点为" << curNode->next->name << endl;
			break;
		}
		curNode = curNode->next;
	}
	cout << "查找方法执行完毕" << endl;
}

// 修改
void update_link(LinkNode *head,int oldvalue,int newValue) {
	LinkNode *curNode = head->next;

	while (curNode!=NULL) {
		if (curNode->name == oldvalue) {
			curNode->name = newValue;
			cout << oldvalue << "--->" << newValue << endl;
			break;
		}
	}

}


int main() {
	LinkNode *head = NULL;
	head=creat_head_link(head);
	init_link(head);

	display_link(head);

	LinkNode *insertNode = (LinkNode *)malloc(sizeof(LinkNode));
	insertNode->name = 100000;
	insertNode->next = NULL;

	cout << "----------" << endl;

	insert_value(head, 8, insertNode);
	display_link(head);

	cout << "----------" << endl;

	delete_node_by_name(head,100000);
	display_link(head);

	cout << "----------" << endl;
	findNodeByName(head,8);

	system("pause");


}
