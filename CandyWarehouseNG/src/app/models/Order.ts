export class Order{

	id: number;
	qtyOrdered: number;
	totalPrice: number;
	dateOrdered: string;
	shippingType: string;
	shipped: boolean;

    constructor(id: number,	qtyOrdered: number, totalPrice: number, dateOrdered: string, 
        shippingType: string, shipped: boolean){
        
        this.id = id;
        this.qtyOrdered = qtyOrdered;
        this.totalPrice = totalPrice;
        this.dateOrdered = dateOrdered;
        this.shippingType = shippingType;
        this.shipped = shipped;
        
    }

}