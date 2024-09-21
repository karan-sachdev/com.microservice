package com.example.inventory.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.inventory.dao.ProductDao;
import com.example.inventory.model.Product;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    private CriteriaBuilder cb;

    @PostConstruct
    private void initialize() {
        this.cb = entityManager.getCriteriaBuilder();
    }

    @Override
    public List<Product> getAllProducts() {
        CriteriaQuery<Product> cp = cb.createQuery(Product.class);
        Root<Product> product = cp.from(Product.class);
        Predicate deletedPredicate = cb.equal(product.get("deleted"), false);
        cp.where(deletedPredicate);
        TypedQuery<Product> query = entityManager.createQuery(cp);
        return query.getResultList();
    }

    @Override
    public Product findProductById(long id) {
        CriteriaQuery<Product> cp = cb.createQuery(Product.class);
        Root<Product> product = cp.from(Product.class);
        Predicate deletedPredicate = cb.equal(product.get("id"), id);
        cp.where(deletedPredicate);
        TypedQuery<Product> query = entityManager.createQuery(cp);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public void deleteProductById(long id) {
        CriteriaQuery<Product> cp = cb.createQuery(Product.class);
        Root<Product> product = cp.from(Product.class);
        Predicate deletedPredicate = cb.equal(product.get("id"), id);
        cp.where(deletedPredicate);
        entityManager.remove(cp);
    }

    @Override
    public List<Product> getProductByQuantity(Long quantity) {
        CriteriaQuery<Product> cp = cb.createQuery(Product.class);
        Root<Product> root = cp.from(Product.class);
        root.fetch("quantity", JoinType.LEFT);
        cp.where(cb.greaterThan(root.get("quantity"), quantity));
        TypedQuery<Product> query = entityManager.createQuery(cp);
        return query.getResultList();
    }

    @Override
    public Integer getTotalActiveProducts() {
       CriteriaQuery<Product> query = cb.createQuery(Product.class);
       Root<Product> root = query.from(Product.class);
       query.where(cb.equal(root.get("deleted"), false));
       TypedQuery<Product> typedQuery = entityManager.createQuery(query);
       return Integer.valueOf(typedQuery.getResultList().size());
    }

}
