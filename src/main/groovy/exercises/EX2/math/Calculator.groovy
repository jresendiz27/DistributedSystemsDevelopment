package exercises.EX2.math

/**
 * Created by alberto on 3/27/15.
 */
import groovy.util.logging.*

class Calculator {

    def sum(List elements) {
        if (elements) {
            return elements.sum()
        } else {
            return 0
        }

    }

    def subtract(List elements) {
        if (elements) {
            def result = elements[0];
            elements.remove(0)
            elements.each {
                result -= Double.parseDouble("$it");
            }
            return result
        } else {
            0
        }

    }

    def multiply(List elements) {
        def result = 1
        if (elements) {
            elements.each {
                result *= Double.parseDouble("$it");
            }
            return result
        } else {
            return 0
        }
    }

    def divide(List elements) throws Exception {
        if (elements) {
            def result = Double.parseDouble(elements[0]);
            elements.remove(0)
            elements.each {
                result /= Double.parseDouble("$it");
            }
            return result
        } else {
            return 0.0
        }
    }

    def linearSearch(List elements, def element) {
        return elements.find { it == element }
    }

    def binarySearch(List elements, def element) {
        if (elements) {
            def sortedElements = elements?.sort()
            def index = Collections.binarySearch(sortedElements, element)

            if (index > 0) {
                return sortedElements[index]
            }
        }
        return null
    }

    def selectionSort(List elements) {
        if (elements) {
            for (i in 0..elements.size() - 1) {
                def curr = i

                for (j in curr..elements.size() - 1) {
                    if (elements[j] < elements[curr]) {
                        curr = j
                    }
                }

                Collections.swap(elements, i, curr)
            }

            return elements
        } else {
            return elements
        }

    }

    def quickSort(List elements) {
        return elements?.sort()
    }

    def mergeSort(List elements) {
        def result

        if (elements?.size() <= 1) {
            return elements
        } else {
            List left, right
            def lst_size = elements?.size();
            int lst_mid = (lst_size - 1) / 2

            left = elements[0..lst_mid]
            right = elements[lst_mid + 1..lst_size - 1]

            left = mergeSort(left)
            right = mergeSort(right)

            result = merge(left, right)

            return result
        }
    }

    List merge(List left, List right) {
        List result = []

        while (left.size() > 0 && right.size() > 0) {

            def l_size = left.size()
            def r_size = right.size()

            if (left[0] <= right[0]) {
                result << left[0]

                if (l_size > 1) {
                    left = left[1..l_size - 1]
                } else {
                    left = []
                }

            } else {
                result << right[0]
                if (r_size > 1) {
                    right = right[1..r_size - 1]
                } else {
                    right = []
                }
            }

        }
        if (left.size() > 0) result += left
        if (right.size() > 0) result += right

        return result
    }
}
