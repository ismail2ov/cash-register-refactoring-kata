# Cash register

## The history

In our neighborhood there is a store called **Happy Baby**, and it offers everything for baby care.  
The owners are very nice and offer a very close treatment, that's why we like to buy there.  
There are also a lot of discounts and a point system with which you can choose different gifts.  

One day we went to buy some things we needed such as shampoo, wipes, diapers, etc ...   
When I was at the checkout, after passing my purchase through the cash register, the cashier told me that there were offers on the diapers, that we had taken 2 and the third pair that is free, we are not taking it. She told me to wait for a little while, and now they take them out. She called on the phone and asked for the third pack of diapers that I was not wearing.  
I asked if there were other offers, and she told me about the offers that my products had, but the only thing that interested me was the porridge that my son loved from Brevit and that sometimes ends before the end of the month that they had 70% in the second pair. I went to find another pack, they were very close to the cash register. At this point the store owner came with the third pack of diapers.
As I was telling you, very nice people.

The cashier asked the boss what was wrong with the **Zero Paper** system. They were people very involved with the environment and they would want to stop giving paper tickets to customers who would not want it. They would like to create an App so that customers can see their tickets, but for now they were going to offer a service that sends the purchase ticket by email, until the app is ready.

As they knew it was computer technician, for **Muggles** (_that's what I call people who make no difference between a software developer and a systems engineer_), we are all computer technician, they asked me if I could take a look.

His system had a Java application that was interacting with different peripherals. Luckily they had the source code left by the developer, a guy fresh out of college who didn't want to make the changes. And they needed to make more changes apart from sending the ticket in HTML format by email.

## Given

My initial purchase was:

|  Product Name |  Unit price |  Quantity | Offer  |
| ------------ | ------------ | ------------ | ------------ |
|  Dodot Sensitive Wipes | 2,30  |  6 | -  |
|  Pants Dodot size | 24,70  | 2  |  3x2 |
|  Chicco Soft Silicone Pacifier |  5,99  |  1 |  3x2 |
|  Johnson's Baby Shampoo |  4,09 | 2  |  Promoted |
|  Blevit Plus Multigrain porridge |  12,27 | 1  | Second unit 70% less  |
|  Hero Baby Puree, vegetables with chicken | 6,05  |  1 | Second unit 70% less  |
|  Puleva infant milk  |  1,45  | 12  |  - |

After the cashier will let me know about the offers, I have also bought:

|  Product Name |  Unit price |  Quantity | Offer  |
| ------------ | ------------ | ------------ | ------------ |
|  Pants Dodot size | 24,70  | 2  |  3x2 |
|  Blevit Plus Multigrain porridge |  12,27 | 1  | Second unit 70% less  |


My ticket has been like this:

    Statement for John Doe
    	 Dodot Sensitive Wipes: 6 x 2,30 = 13,80 €
    	 Pants Dodot size 4: 3 x 24,70 = 49,40 €
    	 Chicco Soft Silicone Pacifier: 1 x 5,99 = 5,99 €
    	 Johnson's Baby Shampoo: 2 x 4,09 = 8,18 €
    	 Blevit Plus Multigrain porridge: 2 x 12,27 = 15,95 €
    	 Hero Baby Puree, vegetables with chicken: 1 x 6,05 = 6,05 €
    	 Puleva infant milk: 12 x 1,45 = 17,40 €
    ---
    Number of items: 27
    ---
    Credits accumulated in this purchase: 3
    ---
    Total amount: 116,77 €

## Goal:
Refactor code and implement print statement in HTML format

In HTML format, the ticket should look like this:

```html
Statement for <b>John Doe</b><br />
	 <b>Dodot Sensitive Wipes:</b> 6 x 2,30 = <b>13,80 €</b><br />
	 <b>Pants Dodot size 4:</b> 3 x 24,70 = <b>49,40 €</b><br />
	 <b>Chicco Soft Silicone Pacifier:</b> 1 x 5,99 = <b>5,99 €</b><br />
	 <b>Johnson's Baby Shampoo:</b> 2 x 4,09 = <b>8,18 €</b><br />
	 <b>Blevit Plus Multigrain porridge:</b> 2 x 12,27 = <b>15,95 €</b><br />
	 <b>Hero Baby Puree, vegetables with chicken:</b> 1 x 6,05 = <b>6,05 €</b><br />
	 <b>Puleva infant milk:</b> 12 x 1,45 = <b>17,40 €</b><br />
---<br />
<b>Number of items:</b> 27<br />
---<br />
<b>Credits accumulated in this purchase:</b> 3<br />
---<br />
<b>Total amount:</b> 116,77 €<br />
```
