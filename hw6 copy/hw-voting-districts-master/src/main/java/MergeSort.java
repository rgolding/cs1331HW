
/**
 * Represents MergeSort for a List
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */
public class MergeSort {


/**
 * Sorts leftHalf and rightHalf
 * @param lds array, unsorted
 * @return lds Array of Local Districts
 */
    public static LocalDistrict[] mergeSort(LocalDistrict[] lds) {
        if (lds.length > 1) {

            LocalDistrict[] left = leftHalf(lds);
            LocalDistrict[] right = rightHalf(lds);


            mergeSort(left);
            mergeSort(right);

            merge(lds, left, right);
        }
        return lds;
    }
/**
 * Sorts leftHalf of array
 * @param array array of left half of array
 * @return left left half of array, sorted.
 */
    public static LocalDistrict[] leftHalf(LocalDistrict[] array) {
        int size1 = array.length / 2;
        LocalDistrict[] left = new LocalDistrict[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
/**
 * Sorts rightHalf of array
 * @param array array of right half of array
 * @return right right half of array, sorted.
 */
    public static LocalDistrict[] rightHalf(LocalDistrict[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        LocalDistrict[] right = new LocalDistrict[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
/**
 * Merges the two halves of array
 * @param result array of Local Districts
 * @param left left half array of Local Districts
 * @param right right half array of Local Districts
 */
    public static void merge(LocalDistrict[] result,
                             LocalDistrict[] left, LocalDistrict[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length
                && left[i1].getNumVoters() <= right[i2].getNumVoters())) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }
}