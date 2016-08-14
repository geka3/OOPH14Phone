package net.ukr.geka3;

import java.util.Arrays;

public class Network {
	Phone[] registeredPhones = new Phone[10];
	int quantityOfRegNumbers;

	public boolean registerNumber(Phone phone) {
		int phoneNumber = phone.getMyNumber();

		// �������� ��������������� ����� ��� ��� ���
		if(isNumberAtNetwork(phoneNumber)){
			System.out.println("number already is at network");
			return false;
		}
		//�������� �� ����� ������� 
		if (quantityOfRegNumbers < registeredPhones.length + 10) {
			// ���������� �������� �������
			registeredPhones = Arrays.copyOf(registeredPhones, registeredPhones.length + 10);
		}

		registeredPhones[quantityOfRegNumbers] = phone;
		quantityOfRegNumbers++;
		
		System.out.println(phone.getMyNumber() + " is registered");
		
		return true;
	}

	public boolean unregisterNumber(Phone phone) {
		for (int i = 0; i < registeredPhones.length; i++) {
			if (registeredPhones[i] == phone) {
				// registeredNumbers[i] = 0; �������� �������� ���
				
				quantityOfRegNumbers--;
				restructuring(registeredPhones, i);
			}
		}
		System.out.println(phone.getMyNumber() + " is unregistered");
		return true;
	}
	//�������� ��������� �������, ���� ������� ������� � ������� ��� ��� ������� ��������
	public void restructuring(Phone[] phones, int from) {
		for (int i = from; i < phones.length - 1; i++) {
			phones[i] = phones[i + 1];
		}
		
		phones[phones.length - 1] = null;

	}
	
	public boolean isNumberAtNetwork(int number){
		for (int i = 0; i < registeredPhones.length; i++){
			if(registeredPhones[i] != null && registeredPhones[i].getMyNumber() == number ){
				return true;
			}
		}
		return false;
		
	} 
	public Phone getPhoneByNumber(int number){
		for( Phone phone : registeredPhones){
			if(phone != null && phone.getMyNumber() == number){
				return phone;
			}
		}
		return null;
	}

	// public void extendArray(int [] array, int numExtend){
	// int[] temp = new int[array.length + numExtend];
	// Arrays.copyOf(original, newLength)
	// }
}
