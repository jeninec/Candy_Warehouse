export class Item{

    id: number;
	name: string;
	catagory: string;
	price: number;
	qty: number;
	description: string;
	imgSrc: string;
    qtyOrdered: number;

    constructor(id: number, name: string, catagory: string, price: number, qty: number,
        description: string, imgSrc: string, qtyOrdered: number){

        this.id = id;
        this.name = name;
        this.catagory = catagory;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.imgSrc = imgSrc;
        this.qtyOrdered = qtyOrdered;
    }


}