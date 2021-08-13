import { Item } from "./Item";

export class Order{

	id: number;
	totalPrice: number;
	dateOrdered: string;
	shippingType: string;
	shipped: boolean;
    qtyO: number[];
    itemId: Item[];


    constructor(id: number, totalPrice: number, dateOrdered: string, 
        shippingType: string, shipped: boolean, qtyO: number[], itemId: Item[]){
        
        this.id = id;
        this.totalPrice = totalPrice;
        this.dateOrdered = dateOrdered;
        this.shippingType = shippingType;
        this.shipped = shipped;
        this.qtyO = qtyO;
        this.itemId = itemId;
        
    }

}