import React, { useEffect, useState } from "react"
import { getProducts } from "apis/products"


const ProductListView = ({ shopId }) => {
    const service = {
        subscribe: () => Promise.resolve("subscribed")
    }

    const [productList, setProductList] = useState(null);

    let list = []

    useEffect(() => {
        service.subscribe().then(a => {
            getProducts(shopId).then(b => {
                let { result } = fetchList(b.data)
                setProductList(result)
            })
        })
    }, [shopId])
  
    var fetchList = (data) => {
        list = []
        const make = (data) => {
            for (let i=0; i<data.length; i++) {
                const product = data[i]
                list.push(product)
            }
            return { list }
        }
        return make(data)
    }

    return (
        <div>
            {productList.map((a, index) => {
                <span key={index}>{a.name}</span>
            })}
        </div>
    )
}

export default ProductListView