# Courier Kata

You work for a courier company and have been tasked with creating a code library to
calculate the cost of sending an order of parcels.

- ✅ - Denotes implementation complete/attempted
- ❌ - Denotes implementation not yet attempted/complete


● The API for the library should be programmatic. There is no need to implement a CLI,
HTTP, or any other transport layer ✅ 

● Try not to peek ahead at future steps and commit your working as you go ✅

● Input can be in any form you choose ✅

● Output should be a collection of items with their individual cost and type, as well as
total cost ✅

● In all circumstances the cheapest option for sending each parcel should be selected. ✅

● You are expected to use test driven development ✅

● Take no longer than 2 hours! Do what you can and give us a rough outline of what
further changes you might consider making.

# Implementation Steps

1) The initial implementation just needs to take into account a parcel's size. For each size
type there is a fixed delivery cost

● Small parcel: all dimensions < 10cm. Cost $3 ✅

● Medium parcel: all dimensions < 50cm. Cost $8 ✅

● Large parcel: all dimensions < 100cm. Cost $15 ✅

● XL parcel: any dimension >= 100cm. Cost $25 ✅

2) Thanks to logistics improvements we can deliver parcels faster. This means we can
charge more money. Speedy shipping can be selected by the user to take advantage of our
improvements.

● This doubles the cost of the entire order ✅

● Speedy shipping should be listed as a separate item in the output, with its associated
cost ✅

● Speedy shipping should not impact the price of individual parcels, i.e. their individual
cost should remain the same as it was before ✅

3) There have been complaints from delivery drivers that people are taking advantage of our
dimension only shipping costs. A new weight limit has been added for each parcel type, over
which a charge per kg of weight applies

+$2/kg over weight limit for parcel size:

● Small parcel: 1kg ✅

● Medium parcel: 3kg ✅

● Large parcel: 6kg ✅

● XL parcel: 10kg ✅

4) Some of the extra weight charges for certain goods were excessive. A new parcel type
has been added to try and address overweight parcels
Heavy parcel (limit 50kg), $50. +$1/kg over ✅

5) In order to award those who send multiple parcels, special discounts have been
introduced.

● Small parcel mania! Every 4th small parcel in an order is free! ✅

● Medium parcel mania! Every 3rd medium parcel in an order is free! ✅

● Mixed parcel mania! Every 5th parcel in an order is free! ✅ 

● Each parcel can only be used in a discount once ❌

● Within each discount, the cheapest parcel is the free one ❌

● The combination of discounts which saves the most money should be selected every
time ❌

Example:
6x medium parcel. 3 x $8, 3x $10. 1st discount should include all 3 $8 parcels and save $8.
2nd discount should include all 3 $10 parcels and save $10.

● Just like speedy shipping, discounts should be listed as a separate item in the output,
with associated saving, e.g. "-2" ✅ 

● Discounts should not impact the price of individual parcels, i.e. their individual cost
should remain the same as it was before ✅

● Speedy shipping applies after discounts are taken into account ✅

# Remarks On Implementation

- I have completed implementations 1-4 and approx 50-60% of implementation 5
- I prioritised testing over feature implementation which is partly why I wasn’t able to finish implementation 5
- There is no UI/CLI - the application is purely TDD i.e when wanting to check the logic of the program each unit test as described should be run to confirm the behaviour of the app as per the specification
- Unit test names are verbose to aid readability and optimise the number of code comments 
- I did not fully understand the requirements/wording of implementation 5 with “Each parcel can only be used in a discount once” vs “ In all circumstances the cheapest option for sending each parcel should be selected.” Even with my best guess attempt I wasn’t able to make progress so decided to re-prioritise on testing existing features.

Rough outline of further changes I would consider making (based on what was not completed):

# Each parcel can only be used in a discount once
The wording of this confused me. If this means that, for example, “small parcel mania” can be applied to the 4th small parcel ONCE (which is my interpretation) then one way could be to have a boolean set with the filter to when 4/4 = 1. I.e when there are multiple small parcel discounts there would be increasing multiples of 4. If the condition of 4/4 = 1 is met then the boolean could be inversely set in the discount method for each type. 

# Within each discount, the cheapest parcel is the free one 
One way this could be achieved would be by sorting the parcels arraylist and filtering out the cheapest parcel based on whether or not the discount in question has been applied and disregarding others

# The combination of discounts which saves the most money should be selected every time

This one is more challenging, I believe the parcel list may still need to be sorted, then to first check the overweight parcels and whether they are in the mixed mania discount and then work down to medium and then small parcel types. This is because the greatest savings on “free” parcels will be on heavier/overweight parcels or ones with a high unit cost. If a mixed mania discount ends up being a small parcel then the savings are not as high as a large parcel. I’d be open to discussing in the next stage.

# Other Remarks 
- The exercise doesn’t explicitly ask for it, and I looked at it quite late as a result but in the displayOrderContents() method or otherwise, it would be more accurate to show the overweight charge alongside the individual parcel cost for user experience. I currently display the total savings as requested in the spec. The tests are correct programmatically and account for overweight charges but the console print of the parcels doesn’t currently display which parcel types are overweight ones. 

- I would refactor the setParcelCostBySize() method in the Parcel class to reduce the number of If statements but I can’t immediately think how I would do this. I noticed late in implementation that my calculation for a heavy parcel is possibly not correct as I had interpreted earlier on that a heavy parcel was one that was 50kg or above. Whereas I believe that in actuality there is a swing range below 50kg where a parcel should still be classed as heavy. I did not have time to implement corrections for this.

