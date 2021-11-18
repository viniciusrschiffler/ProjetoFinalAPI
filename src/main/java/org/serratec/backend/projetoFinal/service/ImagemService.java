package org.serratec.backend.projetoFinal.service;

import java.io.IOException;
import javax.transaction.Transactional;
import org.serratec.backend.projetoFinal.domain.Imagem;
import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class ImagemService {
	
	@Autowired
	private ImagemRepository ImagemRepository;

	@Transactional
	public Imagem create(Produto produto, MultipartFile file) throws IOException {
		Imagem imagem = new Imagem();
		imagem.setName(produto.getNome());
		imagem.setMimetype(file.getContentType());
		imagem.setData(file.getBytes());
		imagem.setProduto(produto);
		return ImagemRepository.save(imagem);
		 
	}
}
