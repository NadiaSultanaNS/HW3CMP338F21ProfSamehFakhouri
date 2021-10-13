/**
 * 
 * <p>
 * 	This interface will be used to organize and manage test times that are measured for specific operations.
 * 	Implementing this interface requires the following:
 * </p>
 * 
 * <ul>
 *    <li>
 *    	The implementation is required to save the last 10 time measurements. If the user adds exactly 10 
 *    	measurements, the implementation will keep all 10. If the user adds <b>n</b>, where <b>n &gt; 10</b>,
 *    	the implementation will keep the last 10 measurements.  
 *    </li>
 *    
 *    <li>
 *    	If you have made no measurements, your array will contain the following:
 *    	[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]. 
 *    </li>
 *    
 *    <li>
 *    	If you have made 5 measurements <b>m<sub>n</sub></b>, your array will contain the following:
 *    	[m<sub>1</sub>, m<sub>2</sub>, m<sub>3</sub>, m<sub>4</sub>, m<sub>5</sub>, 0, 0, 0, 0, 0]. 
 *    </li>
 *    
 *    <li>
 *    	If you have made 10 measurements <b>m<sub>n</sub></b>, your array will contain the following:
 *    	[m<sub>1</sub>, m<sub>2</sub>, m<sub>3</sub>, m<sub>4</sub>, m<sub>5</sub>, m<sub>6</sub>, m<sub>7</sub>, m<sub>8</sub>, m<sub>9</sub>, m<sub>10</sub>]. 
 *    </li>
 *    
 *    <li>
 *    	If you have made 13 measurements <b>m<sub>n</sub></b>, your array will contain the following:
 *    	[m<sub>4</sub>, m<sub>5</sub>, m<sub>6</sub>, m<sub>7</sub>, m<sub>8</sub>, m<sub>9</sub>, m<sub>10</sub>, m<sub>11</sub>, m<sub>12</sub>, m<sub>13</sub>]. 
 *    </li>
 *    
 *    <li>
 *    	Please pay attention to the ordering of the measurements described above. 
 *    </li>
 *    
 *    <li>
 *    	The implementation is required to compute <b>average</b> calculations using only added measurements.
 *    </li>
 *    
 *    <li>
 *    	If the user has added only 3 measurements <b>m<sub>n</sub></b>, then the average is 
 *    	(m<sub>1</sub> + m<sub>2</sub> + m<sub>3</sub>)/3. 
 *    </li>
 *    
 *    <li>
 *    	If the user has added 10 measurements, then the average is 
 *    	(m<sub>1</sub> + m<sub>2</sub> + m<sub>3</sub> + m<sub>4</sub> + m<sub>5</sub> + m<sub>6</sub> + m<sub>7</sub> + m<sub>8</sub> + m<sub>9</sub> + m<sub>10</sub>)/10.
 *    </li>
 *    
 *    <li>
 *    	If the user has added <b>n</b> measurement, where <b>n > 10</b>, then the average is 
 *    	(m<sub>n-9</sub> + m<sub>n-8</sub> + m<sub>n-7</sub> + m<sub>n-6</sub> + m<sub>n-5</sub> + m<sub>n-4</sub> + m<sub>n-3</sub> + m<sub>n-2</sub> + m<sub>n-1</sub> + m<sub>n</sub>)/10.
 *    </li>
 *    
 *    <li>
 *    	The implementation will represent all nanosecond time measurements as <code>long</code> values.
 *    </li>
 *    
 *    <li>
 *    	The implementation will compute averages and represent them as <code>double</code> values.
 *    </li>
 *	</ul>
 *
 *	<p>
 * 		Users of an implementation of this interface calculate time measurements as follows: 
 *	</p>
 *
 *	<ul>
 *    <li>
 *		Before the operation is started, you can obtain the start time:
 * 		<br>
 * 		<code>long startTime = System.nanoTime()</code>. 
 *    </li>
 * 
 *    <li>
 * 		After the operation is completed, you can obtain the end time:
 * 		<br>
 * 		<code>long endTime = System.nanoTime()</code>.
 *    </li>
 *    
 *    <li>
 *		Test Time can then be computed:
 * 		<br>
 * 		<code>long testTime = endTime - startTime</code>.
 *    </li>
 * </ul>
 * 
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface TestTimesInterface {
	
	/**
	 * 
	 * This method is used to retrieve the last test time. If no test time
	 * has been added, the method will return a zero.
	 * 
	 * @return The last test time, in nanoseconds, or zero.
	 *  
	 */
	public long getLastTestTime();
	
	/**
	 * 
	 * This method returns an array of <b>long</b> values representing the last 10 test times. 
	 * If less than 10 test times are available, the remaining
	 * test times should be zero. If more than 10 test times have been added, the array
	 * should contain the last 10 test times. 
	 * 
	 * @return An array of <b>long</b> values representing the last 10 test times.
	 * 
	 */
	public long[] getTestTimes();

	/**
	 * 
	 * This method is used to reset all 10 linear search times to zero.
	 * 
	 */
	public void resetTestTimes();

	/**
	 * 
	 * This method is used to add a test time.
	 * If more than 10 test times get added, this method will keep the last 10 
	 * test times. 
	 * 
	 * @param testTime a <b>long</b> value representing the test time in nanoseconds.
	 * 
	 */
	public void addTestTime(long testTime);
	
	/**
	 * 
	 * This method is used to obtain the average test time. The method should average all
	 * the non-zero test times that are available. If no test times are available, the method
	 * returns a zero.
	 * 
	 * @return A <b>double</b> value representing the average of all the non-zero test times, or zero.
	 * 
	 */
	public double getAverageTestTime();
	
}
