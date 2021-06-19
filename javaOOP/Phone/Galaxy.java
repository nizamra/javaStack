
public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
		return this.getRingTone();
	}
	@Override
	public String unlock() {
		return "unlock via facial recognition";
	}
	@Override
	public void displayInfo() {
		System.out.println("Galaxy [ring()=" + ring() + ", unlock()=" + unlock() + ", getVersionNumber()=" + getVersionNumber()
				+ ", getBatteryPercentage()=" + getBatteryPercentage() + ", getCarrier()=" + getCarrier()
				+ ", getRingTone()=" + getRingTone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]");
	}
	
}