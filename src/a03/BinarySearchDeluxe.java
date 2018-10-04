/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import java.util.Comparator;

/**
 * Class BinarySearchDeluxe has two generic methods used to find the first or
 * last instance of a key in an array given a comparator with the same type as
 * the key.
 * 
 * @author SpencerR, William McConnell
 *
 */
public class BinarySearchDeluxe {

	/**
	 * Return the index of the first key in a[] that equals the search key, or -1 if
	 * no such key.
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null)
			throw new NullPointerException("Parameters must not be null.");
		
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if ((mid == 0 || comparator.compare(key, a[mid-1]) > 0) &&
					comparator.compare(a[mid], key) == 0)
				return mid;
			else if (comparator.compare(key, a[mid]) > 0)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return -1;
	}

	/**
	 * Return the index of the last key in a[] that equals the search key, or -1 if
	 * no such key.
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null)
			throw new NullPointerException("Parameters must not be null.");
		
		int lo = 0;
		int hi = a.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if ((mid == a.length - 1 || comparator.compare(key, a[mid+1]) < 0) &&
					comparator.compare(a[mid], key) == 0)
				return mid;
			else if (comparator.compare(key, a[mid]) < 0)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}
}
