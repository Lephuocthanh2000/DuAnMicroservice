import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

const ProductList = () => {

    const [product, setProduct] = useState([]);
    const [loading, setLoading] = useState(false);


    useEffect(() => {
        setLoading(true);

        fetch('/product')
            .then(response => response.json())
            .then(data => {
                setProduct(data);
                setLoading(false);
            })
    }, []);

    const remove = async(id) => {
        await fetch(`/product/${id}`, {
            method: 'DELETE',
            headers: {

                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        }).then(() => {
            let updateProduct = [...product].filter(i => i.id !== id);
            setProduct(updateProduct);
        });
    }

    if (loading) {
        return <p > Loading... < /p>;
    }

    const productList = product.map(product => {
        const name = `${product.name || ''} `;
        return <tr key = { product.id } >
            <
            td style = {
                { whiteSpace: 'nowrap' }
            } > { product.name } < /td> <
        td > { name } < /td> <
        td > {
            product.category.map(category => {
                return <div key = { category.id } > {
                    new Intl.DateTimeFormat('en-US', {}).format(new Date(category.date))
                }: { category.name } < /div>
            })
        } < /td> <
        td >
            <
            ButtonGroup >
            <
            Button size = "sm"
        color = "primary"
        tag = { Link }
        to = { "/product/" + product.id } > Edit < /Button> <
        Button size = "sm"
        color = "danger"
        onClick = {
            () => remove(product.id)
        } > Delete < /Button> < /
        ButtonGroup > <
            /td> < /
        tr >
    });

    return ( <
        div >
        <
        AppNavbar / >
        <
        Container fluid >
        <
        div className = "float-end" >
        <
        Button color = "success"
        tag = { Link }
        to = "/Product/new" > Add Product < /Button> </div >
        <
        h3 > List Products < /h3>  <
        Table className = "mt-4" >
        <
        thead >
        <
        tr >
        <
        th width = "20%" > Name < /th> <th width = "20%" > Name category </th > < th > Events < /th> <th width = "10%" > price </th > < /tr > < /
        thead > <
        tbody > { productList } <
        /tbody> < /
        Table > <
        /Container> < /
        div >
    );
};

export default ProductList;