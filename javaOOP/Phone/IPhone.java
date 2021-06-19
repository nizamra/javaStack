
public class IPhone extends Phone implements Ringable {
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
		return this.getRingTone();
	}
	@Override
	public String unlock() {
		return "unlock via fingerprint";
	}
	@Override
	public void displayInfo() {
		System.out.println("IPhone [ring()=" + ring() + ", unlock()=" + unlock() + ", getVersionNumber()=" + getVersionNumber()
				+ ", getBatteryPercentage()=" + getBatteryPercentage() + ", getCarrier()=" + getCarrier()
				+ ", getRingTone()=" + getRingTone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]");
	}
	
}