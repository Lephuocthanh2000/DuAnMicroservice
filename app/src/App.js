import React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ProductEdit from './ProductEdit';
import ProductList from './ProductList';

const App = () => {
    return ( <
        Router >
        <
        Routes >
        <
        Route exact path = "/"
        element = { < Home / > }
        /> <
        Route path = '/product'
        exact = { true }
        element = { < ProductList / > }
        /> <
        Route path = '/product/edit/:id'
        element = { < ProductEdit / > }
        /> < /
        Routes > <
        /Router>
    )
}

export default App;