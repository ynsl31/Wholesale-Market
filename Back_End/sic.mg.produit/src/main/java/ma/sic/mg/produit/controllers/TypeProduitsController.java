package ma.sic.mg.produit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.sic.mg.produit.entities.TypeProduit;
import ma.sic.mg.produit.repositories.ISousTypeProduitRepository;
import ma.sic.mg.produit.repositories.ITypeProduitRepository;



@RestController
@RequestMapping("typeproduits")
@CrossOrigin(origins = "http://localhost:4200")  
public class TypeProduitsController {
	@Autowired
	private ITypeProduitRepository ProduitRepository;
	
	@GetMapping("/all")
	public List<TypeProduit> findAll(){
		return ProduitRepository.findAll();
	} 
	@GetMapping("/find/{id}")
	public TypeProduit findProduit(@PathVariable(required = true) String id){
		return ProduitRepository.findById(Integer.parseInt(id));
	}
	
	
	@PostMapping("/save")
	public void save(@RequestBody TypeProduit Produit) {
		ProduitRepository.save(Produit);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) String id){
		System.out.println("id = "+id);
		TypeProduit Produit=ProduitRepository.findById(Integer.parseInt(id));
		ProduitRepository.delete(Produit);	
	}

	

}