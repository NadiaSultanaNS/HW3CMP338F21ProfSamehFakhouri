import java.util.Arrays;

public class TestTimes implements TestTimesInterface {

	private long[] testTimes = new long[10];
	// [m4, m5, m6, m7, m8, m9, m10, m11, m12, m13] 
	
	private int count = 0;
	// 10
	
	@Override
	public long getLastTestTime() {
		if (this.count == 0) {
			return 0;
		}
		else if (this.count < 10) {
			return this.testTimes[this.count - 1];
		} 
		else {
			return this.testTimes[9];
		}
	}

	@Override
	public long[] getTestTimes() {
		long[] newTestTimes= Arrays.copyOf(testTimes, this.testTimes.length);
		return newTestTimes;
		
	}

	@Override
	public void resetTestTimes() {
		for ( int i = 0 ; i < this.testTimes.length ; i++ ) {
			this.testTimes[i] = 0;
		}
		this.count = 0;
	}

	@Override
	public void addTestTime(long testTime) {
		if (this.count < 10) {
			this.testTimes[count++] = testTime;
		} 
		else {
			for ( int i = 0 ; i < this.testTimes.length - 1 ; i++ ) {
				this.testTimes[i] = this.testTimes[i+1];
			}
			this.testTimes[9] = testTime;
		}
	}

	@Override
	public double getAverageTestTime() {
		if (count == 0) {
			return 0;
		}
		double average=0;
		double sum=0;
		for (int i=0; i<this.count; i++) {
			sum+=this.testTimes[i];
			
		}
		average= sum/(double)count;
		return average;
	}

}
