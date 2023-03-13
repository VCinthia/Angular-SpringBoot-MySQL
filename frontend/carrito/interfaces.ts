export interface Juego{
    id : number;
    nombre : string;
    descripcion : string;
    imagen : string;
    precio : number;
}

export interface Detalle{
    id : number;
    cantidad : number;
    subtotal : number;
    ordenId : number;
    productoId : Juego;//ver pasar a number
}

export interface Orden{
    id : number;
    esPromo : boolean;
    fechaCreacion : Date;
    subtotal : number;
    total : number;
    usuario : Usuario;//ver pasar a number
}

export interface Usuario{
    id : number;
    apellido : string;
    nombre : string;
    email : string;
    esVip : boolean;
    password : string;
    esAdmin : boolean;
}