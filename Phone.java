package net.ukr.geka3;

public class Phone {
	private int myNumber;
	private Network iAmRegistered;
	private Phone iAmConnected;

	
	public Phone(int myNumber){
		this.myNumber = myNumber;
		System.out.println("phone with number " + this.myNumber + " is created");
	}
	
	
	public Phone() {
		super();
	}


	public void registerTo(Network network) {
		this.iAmRegistered = network;
		network.registerNumber(this);
		
	}
	
	public void unregister(){
		iAmRegistered.unregisterNumber(this);
		iAmRegistered = null;
	}

	public int getMyNumber() {
		return myNumber;
	}

	// попытка соединитс€
	private boolean connect(Phone phone) {
		if (this.iAmConnected == null) {
			this.iAmConnected = phone;
			System.out.println(this.myNumber + " and " + phone.myNumber + " are connected");

			return true;

		} else {
			return false;
		}

	}

	// попытка св€затс€ с другим номер,
	// при этом абоненты обмен€ютс€ объектами типа Phone
	public void call(int destinationNumber) {
		Phone destinationAbonent;
		// проверка на регистрацию номера в сети
		if ((destinationAbonent = iAmRegistered.getPhoneByNumber(destinationNumber)) != null) {
			// попытка подключитс€
			if (destinationAbonent.connect(this)) {
				iAmConnected = destinationAbonent;
			} else {
				System.out.println("abonent is busy, try agein later");
			}

		} else {
			System.out.println("Number not found at Network");
			return;
		}

	}

	public void hangUp() {
		iAmConnected.disconnect();
		disconnect();
	}

	private void disconnect() {

		iAmConnected = null;
	}

	public Network getiAmRegistered() {
		return iAmRegistered;
	}

}
