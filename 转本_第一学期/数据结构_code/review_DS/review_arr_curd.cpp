#include<iostream>
#include<malloc.h>
using namespace std;

/*
   数组的增删改查
   数组长度为10

*/

// 创建数组
int* create_array(int *p) {
	p = (int *)malloc(sizeof(int) * 10);
	return p;
}
// 数组初始化 只初始化 9个
void init_arrar(int *p) {
	for (int i = 0;i < 9;i++) {
		p[i] = i;
	}
}

// 遍历数组
void display_array(int *p) {
	for (int i = 0;i < 9;i++) {
		cout << p[i] << endl;
	}
}

//  增加元素 [插入元素 在指定下标之前插入]
bool insert_value_before_index(int *p, int index,int value) {
	if (p != NULL) {
	for (int i = 8;i >= index;i++) {
		p[i + 1] = p[i];
	}
	p[index] = value;
	return true;
	}
}

// 删除指定元素
void delete_value_by_index(int *p,int index) {
	for (int i = index;i < 10;i++) {
		p[i - 1] = p[i];
	}
}

// 查找元素
bool find_index_by_value(int *p, int value) {
	for (int i = 0;i < 9;i++) {
		if (p[i] == value) {
			cout << "下标为" << i << endl;
			return true;
		}
	}
	return false;
}

// 改元素 下标改
void update_value_by_index(int *p,int index,int value) {
	if (index < 9) {
		p[index] = value;
	}
	else {
		cout << "下标越界" << endl;
	}

}

int main() {
	int *p = NULL;
	p=create_array(p);

	init_arrar(p);

	display_array(p);

	cout << "---------" << endl;
	delete_value_by_index(p,6);// 删除下标为6的元素

	display_array(p);

	//insert_value_before_index(p, 8, 1000);
	find_index_by_value(p,9);

	cout << "---------" << endl;
	update_value_by_index(p, 8, 10000);

	display_array(p);
	system("pause");



}