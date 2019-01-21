#include<iostream>
using namespace std;

// —°‘Ò≈≈–Ú 
void sortSelect(int arr[],int length) {
	for (int i = 0;i < length - 1;i++) {
		for (int j = i + 1;j < length;j++) {
			if (arr[j] > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}

// √∞≈› 
void sortBubble(int arr[],int length) {
	for (int i = 0;i < length - 1;i++) { // Ë∂üÊï∞
		for (int j = 0;j < length - 1 - i;j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}


void displayArray(int arr[],int length) {
	for (int i = 0;i < length;i++) {
		cout << arr[i] << ",";
	}
}


int main() {
	int arr[] = { 0,1,26,58,56,1,23,-5 };
	sortSelect(arr, 8);
	displayArray(arr, 8);
	cout << "-------" << endl;
	sortBubble(arr, 8);
	displayArray(arr, 8);

}