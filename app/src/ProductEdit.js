import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';


const ProductEdit = () => {
        const initialFormState = {
            name: '',
        };
        const [product, setProduct] = useState(initialFormState);
        const navigate = useNavigate();
        const { id } = useParams();

        useEffect(() => {
            if (id !== 'new') {
                fetch(`/product/edit/${id}`)
                    .then(response => response.json())
                    .then(data => setProduct(data));
            }
        }, [id, setProduct]);

        const handleChange = (event) => {
            const { name, value } = event.target

            setProduct({...product, [name]: value })
        }

        const handleSubmit = async(event) => {
                event.preventDefault();

                await fetch(`/product/edit/${product.id ? `/${product.id}` : ''}`, {
      method: product.id ? 'PUT' : 'POST',
      headers: {
        
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product),
    });
    navigate('/product');
  }

  const title = <h2>{product.id ? 'Edit product' : 'Add Product'}</h2>;

  return (<div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Label for="name">Name</Label>
            <Input type="text" name="name" id="name" value={product.name || ''}
                   onChange={handleChange} autoComplete="name"/>
          </FormGroup>
         
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/product">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  )
};

export default ProductEdit
;