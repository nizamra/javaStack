public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private String carrier;
	private String ringTone;
	public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.carrier = carrier;
		this.ringTone = ringTone;
		}
	
	public abstract void displayInfo();

	/**
	 * @return the versionNumber
	 */
	public String getVersionNumber() {
		return versionNumber;
	}

	/**
	 * @return the batteryPercentage
	 */
	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}

	/**
	 * @return the ringTone
	 */
	public String getRingTone() {
		return ringTone;
	}

	/**
	 * @param versionNumber the versionNumber to set
	 */
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	/**
	 * @param batteryPercentage the batteryPercentage to set
	 */
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	/**
	 * @param ringTone the ringTone to set
	 */
	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}
}