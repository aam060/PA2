1. 
	The Bag2 implementation is unique in that it uses an array instead of an arraylist. 
	This means that the implementation is very limited as the length of the array must be defined 
	at the very begining(in this case it was 10). As a result, it is impossible to add more than 
	10 items to Bag2's object. Bag6 is also similar, however they are different in that Bag2 simply
	does not add an item when an 11th item is added, whereas Bag6 fails and returns a null pointer 
	exception. In this case, Bag2 merely produces the wrong result. 
	
	The Bag11 implementation is unique in that it fails to add duplicates. addedDupeGetTotal() fails on 
	implementation uniquely. Bag2 and 6 fail due to null pointer exception, while Bag11 fails due to an 
	incorrect result. Bag0 fails, because it does pretty much nothing. However, Bag11 is successful in 
	adding one bag, but fails to add a duplicate. That is why it returns the value of 5(price of one
	object) when it should return 10(the price of two objects) 
	
	The Bag10 implementation is unique in that it's removeAll(ref) clears the entire list, not justt removing the 
	ref. This is different from Bag0, because bag10 still mostly functional. For example, Bag10 can add items into
	the bag correctly, and still count. 
	
	
	
	
2.
	Bag0 is buggy because nothing is ever updated whenever any methods are called. For example, adding
		an item changes nothing about the bag. The bag will still say that there are 0 objects when there
		should clearly be one. 
		
	Bag1 is buggy because it reads objects with the same content but different references as different objects when
		they are in practice the same. 
	
	Bag2 is buggy because when an eleventh object is added, nothing about the bag changes; for example, 
		after adding an eleventh object, the totalCount() should say 11, and yet it says 10. 
		
	Bag3 is buggy because when checking the list for a null object, it doesn't return 0; Now, this may be 
		a difference of opinion in what null is, but the fact is the value of the itemCount(null) changes
		depending on the other objects. 
		
	Bag4 is an implementation choice, because the failed tests involving adding null objects to the bag only 
		counts as a failure if you consider null objects countable like other objects. 
	
	Bag5 is buggy. Say I have a bag with two of the same object, then I call removeAll(object); Clearly, 
		both objects should be removed, leaving nothing but Bag5 simply removes one, and there is 
		one more of that same object in the bag. 
		
	Bag6 is buggy because when an eleventh object is added, the the program crashes when an eleventh object
		should be added without any problem. 
		
	Bag7 is buggy in its removeAll() method. Say I had two of an object and I call removeAll() on one of the
		references to that object, then Bag7 will remove the objects correctly, but will return a false boolean, 
		when it should return a true boolean because clearly objects were removed. 
		
	Bag8 is an implementation choice, because I've found nothing majorly  wrong with it; the failed test with removing null 
		is just an opinion on whether or not removing null counts as a removal. 
	
	Bag9 is buggy because it reads objects with the same content but different references as different objects when
		they are in practice the same. 
	
	Bag10 is buggy because it's removeAll(object) clears the entire list, not just removing items that are the same
	as object. 
	
	Bag11 is buggy, because duplicate items could not be added, evident in the fact that a bag of two objects worth
		5 each will return a value of only 5 when totalPrice() is called
		
	