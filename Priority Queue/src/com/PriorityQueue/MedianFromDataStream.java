package com.PriorityQueue;

import java.util.PriorityQueue;

public class MedianFromDataStream {

    static class MedianFinder {
        // Whats the DS we can Use ? A simple arrayList

        // Ok Now to find the median How our arrayList needs to be at all the time ?
        // It needs to be sorted at all the time so that we can find the median.

        // Ok lets say the arrayList is sorted at all the time, Now a new Element comes in, How do we insert it into the arrayList ?
        // We need to know the smaller element than the new element and the bigger element than the new element so that we can insert it in between them.
        // Which takes to move the later half of the arrayList to make space for the new element. So the time complexity of this is O(n/2) = O(n) for each insertion.

        // So for Brute force it is sort plus insert which is O(nlogn) + O(n) = O(nlogn) for each insertion. So the time complexity of this is O(nlogn) for each insertion.
        // Not that Bad right ?

        // Okay Whats the median ? It is the middle element of the sorted arrayList.
        // More precisely the number in the middle of two halfs of where each half is sorted.
        //  So if it is middle of the two halfs which is already sorted do we really need to search the whole two halfs to find the median ?
        // No we just need two elements the largest element of the left half (small bag) and the smallest element of the right half (big bag).

        // So at any instant if I want to know the largest or smallest element what DS can I use ? A Heap (Priority Queue) is the best DS for this.

        PriorityQueue<Integer> smallBag; // Why small bag is max heap ? Because we need the largest element of the small bag to find the median.
        PriorityQueue<Integer> bigBag; // Why big bag is min heap ? Because we need the smallest element of the big bag to find the median.

        public MedianFinder() {
            smallBag = new PriorityQueue<>((a, b) -> b - a); // Max Heap
            bigBag = new PriorityQueue<>(); // Min Heap
        }

        public void addNum(int num) {
            // Now it is a thing ? Which bag we gonna put the new number into ? The small bag or the big bag ?
            //  Lets first get the peaks
            int smallBagPeak = smallBag.isEmpty() ? Integer.MIN_VALUE : smallBag.peek();
            int bigBagPeak = bigBag.isEmpty() ? Integer.MAX_VALUE : bigBag.peek();

            // It is simple if our number is bigger than the small bag peak and smaller than the big bag peak then we can put it in either bag.
            // But if it is smaller than the small bag peak then we need to put it in the small bag and if it is bigger than the big bag peak then we need to put it in the big bag.
            // We can keep it simple if it bigger than the small bag peak then we put it in the big bag else we put it in the small bag.
            if (num > smallBagPeak) {
                bigBag.offer(num);
            } else {
                smallBag.offer(num);
            }

            // There is one small catch, we need to make sure that the size of the two bags are balanced.
            // Why ? IF they ARE NOT NOT BALANCED means the difference is > 1 .
            // Because say the size is 50 then the diff is 0 and size is 51 then the diff is 1 , bsacially for odd size the diff is 1 and for even size the diff is 0 , so if the diff is > 1 then we need to balance the bags.

            while (Math.abs(smallBag.size() - bigBag.size()) > 1) {
                reBalanceBags(smallBag, bigBag);
            }

        }

        private void reBalanceBags(PriorityQueue<Integer> smallBag, PriorityQueue<Integer> bigBag) {
            int smallBagSize = smallBag.size();
            int bigBagSize = bigBag.size();

            if (smallBagSize > bigBagSize) {
                bigBag.offer(smallBag.poll());
            } else {
                smallBag.offer(bigBag.poll());
            }

        }


        public double findMedian() {
            // Now we have two bags and we need to find the median from them.
            // Straight forward , get the size , if the size is even then get the average of the two peaks else get the peak of the bag with bigger size.
            // Why for odd peek of the bag with bigger size ? Because the median is the middle element and if the size is odd then the middle element is in the bag with bigger size.
            // Imagine like if odd the array always splits un even and the middle element is always in the bag with bigger size.


            // It is guranteed that the median will be called only after at least one number has been added, so we don't need to check for empty bags here.
            int totalSize = smallBag.size() + bigBag.size();
            if (totalSize % 2 == 0) {
                return (smallBag.peek() + bigBag.peek()) / 2.0;
            } else {
                return smallBag.size() > bigBag.size() ? smallBag.peek() : bigBag.peek();
            }
        }

        // There are two follow up questions for this problem :
        // 1. What if the numbers are coming in a only in the range of 0 to 100 ?
        // This gets back to the Top K Frequent Elements problem where we can use a bucket sort to keep the count of the numbers and then get the median from the bucket.
        // Similarly we create 101 Buckets and every time we see the number we increment the count in the corresponding bucket say 51 mean bucket[51]++.
        // Then when the median is needed , we walkthrought the buckets and count till we meet the middle count which is totalSize/2.

        // 2. What if 99% of the numbers are in the range of 0 to 100 ? and the rest 1% are out of the range of 0 to 100 ?
        // Simple same solution just keep two variables , numberLessThanZero and numberGreaterThanHundred .
        // Then instead of counting from 0 th bucket we start the running sum from numberLessThanZero and then we count the buckets and then we add numberGreaterThanHundred at the end to get the total count and then we can find the median as before.
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2.0
    }

}
