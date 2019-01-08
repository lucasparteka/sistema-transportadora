package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Desserializador {

    //Método responsável por alterar o status do motorista escolhido para TRABALHANDO, ou seja, não estará disponivel para trabalhar até o próximo dia
//    public void alterarStatusMotorista(String cnh) {
//        Motorista motorista;
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        String caminho = "src\\arquivos\\motoristas\\";
//        File diretorioMotoristas = new File(caminho);
//        File[] listarMotoristas = diretorioMotoristas.listFiles();
//
//        for (File selecionarDiretorio : listarMotoristas) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                motorista = (Motorista) ois.readObject();
//
//                if (motorista.getNumeroCnh().equals(cnh)) {
//                    motorista.setStatusTrabalho(StatusMotorista.TRABALHANDO);
//                    serializar.serializarObjeto(motorista, caminho, cnh);
//
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Motorista não encontrado!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//    }

    //Método responsável por alterar o status do veículo para OCUPADO, ou seja, não estará disponivel para ser usado até o próximo dia
//    public void alterarStatusVeiculo(String placa) {
//        Veiculo veiculo;
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        String caminho = "src\\arquivos\\veiculos\\";
//        File diretorioVeiculos = new File(caminho);
//        File[] listarVeiculos = diretorioVeiculos.listFiles();
//
//        for (File selecionarDiretorio : listarVeiculos) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                veiculo = (Veiculo) ois.readObject();
//
//                if (veiculo.getPlacaVeiculo().equals(placa)) {
//                    veiculo.setStatusVeiculo(StatusVeiculo.OCUPADO);
//                    serializar.serializarObjeto(veiculo, caminho, placa);
//
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Veículo não encontrado!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//    }

    //Método responsável por alterar os status das encomendas que foram selecionadas para EM ANDAMENTO, quer dizer que estão
    //dentro de um roteiro e não receberam um feedback do motorista ainda
//    public void alterarStatusEncomendas(int codigo) {
//        Encomenda encomenda;
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        String caminho = "src\\arquivos\\encomendas\\";
//        File diretorioEncomendas = new File(caminho);
//        File[] listarEncomendas = diretorioEncomendas.listFiles();
//
//        for (File selecionarDiretorio : listarEncomendas) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                encomenda = (Encomenda) ois.readObject();
//
//                if (encomenda.getCodigoEncomenda() == codigo) {
//                    encomenda.setStatusEncomenda(StatusEncomenda.EMANDAMENTO);
//                    //serializar.serializarObjeto(encomenda, caminho, codigo);
//
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Encomenda não encontrada!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//    }
//
//    //Método responsável por retornar o tipo do veículo que foi escolhido na hora de gerar um roteiro
//    public TipoVeiculo retornarTipoVeiculo(String placa) {
//        TipoVeiculo tipoVeiculo = null;
//        Veiculo veiculo;
//
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        String caminho = "src\\arquivos\\veiculos\\";
//        File diretorioMotoristas = new File(caminho);
//        File[] listarMotoristas = diretorioMotoristas.listFiles();
//
//        for (File selecionarDiretorio : listarMotoristas) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                veiculo = (Veiculo) ois.readObject();
//
//                if (veiculo.getPlacaVeiculo().equals(placa)) {
//                    tipoVeiculo = veiculo.getTipoVeiculo();
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Veículo não encontrado!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//
//        }
//        return tipoVeiculo;
//    }
//
    //Método que retorna TODOS os motoristas cadastrados, o filtro de quem tá disponivel para trabalhar é feito depois no método de controle
    public Object desserializar(File local) {
        Object obj;
        //File file = new java.io.File("src\\" + local);
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fin = new FileInputStream(local);
            ois = new ObjectInputStream(fin);
            obj = (Object) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
            return null;

        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo");
            }
        }

        return obj;
    }
//
//    //Método que retorna TODOS os veículos cadastrados, o filtro de quem tá livre para ser usado é feito depois no método de controle
//    public ArrayList<Veiculo> retornarVeiculos() {
//        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
//        String caminho = "src\\arquivos\\veiculos\\";
//        Veiculo obj = new Veiculo();
//        File file = new File(caminho);
//        File[] arrayFiles = file.listFiles();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//
//        for (File selectedFile : arrayFiles) {
//
//            try {
//                fin = new FileInputStream(selectedFile);
//                ois = new ObjectInputStream(fin);
//                obj = (Veiculo) ois.readObject();
//                listaVeiculos.add(obj);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Motorista não encontrado!");
//                return null;
//
//            } finally {
//                try {
//                    if (fin != null) {
//                        fin.close();
//                    }
//                    if (ois != null) {
//                        ois.close();
//                    }
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//        return listaVeiculos;
//    }
//
//    //Método que retorna TODAS as encomendas cadastrados, o filtro das encomendas que estão com os status necessários para serem colocadas em um roteiro
//    //é feito depois no controle
//    public ArrayList<Encomenda> retornarEncomendas() {
//        ArrayList<Encomenda> listaEncomendas = new ArrayList<>();
//        String caminho = "src\\arquivos\\encomendas\\";
//        Encomenda obj = new Encomenda();
//        File file = new File(caminho);
//        File[] arrayFiles = file.listFiles();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//
//        for (File selectedFile : arrayFiles) {
//
//            try {
//                fin = new FileInputStream(selectedFile);
//                ois = new ObjectInputStream(fin);
//                obj = (Encomenda) ois.readObject();
//                listaEncomendas.add(obj);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Encomenda não encontrada!");
//                return null;
//
//            } finally {
//                try {
//                    if (fin != null) {
//                        fin.close();
//                    }
//                    if (ois != null) {
//                        ois.close();
//                    }
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//        return listaEncomendas;
//    }
//
//    //Método responsável por retornar todos os roteiros cadastrados
//    public ArrayList<Roteiro> retornarRoteiros() {
//        ArrayList<Roteiro> listaRoteiros = new ArrayList<>();
//        String caminho = "src\\arquivos\\roteiros\\";
//        Roteiro obj = new Roteiro();
//        File file = new File(caminho);
//        File[] arrayFiles = file.listFiles();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//
//        for (File selectedFile : arrayFiles) {
//
//            try {
//                fin = new FileInputStream(selectedFile);
//                ois = new ObjectInputStream(fin);
//                obj = (Roteiro) ois.readObject();
//                listaRoteiros.add(obj);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Roteiro não encontrado!");
//                return null;
//
//            } finally {
//                try {
//                    if (fin != null) {
//                        fin.close();
//                    }
//                    if (ois != null) {
//                        ois.close();
//                    }
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//        return listaRoteiros;
//    }
//
//    //Método responsável por retornar a configuração atual do programa
//    public Configuracao retornarConfiguracao() {
//
//        Configuracao config = null;
//        String caminho = "src\\arquivos\\configuracao\\";
//
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        File diretorioConfiguracao = new File(caminho);
//        File[] listarConfiguracao = diretorioConfiguracao.listFiles();
//
//        for (File selecionarDiretorio : listarConfiguracao) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                config = (Configuracao) ois.readObject();
//
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Configuração não encontrada!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//
//        }
//
//        return config;
//    }
//
//    public Roteiro retornarRoteiroEscolhido(String codigo) {
//
//        Roteiro roteiro = null;
//        Roteiro roteiroEscolhido = null;
//        String caminho = "src\\arquivos\\roteiros\\";
//
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//        File diretorioRoteiros = new File(caminho);
//        File[] listarRoteiros = diretorioRoteiros.listFiles();
//
//        for (File selecionarDiretorio : listarRoteiros) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                roteiro = (Roteiro) ois.readObject();
//                if (roteiro.getCodigoIdentificador().equals(codigo)) {
//                    roteiroEscolhido = roteiro;
//                }
//
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Roteiro não encontrado!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//
//        }
//
//        return roteiroEscolhido;
//    }
//
//    //Método responsável por setar todos os motoristas cadastrados como disponiveis
////    public void setarStatusMotoristasDisponivel() {
////        Motorista motorista;
////        String caminho = "src\\arquivos\\motoristas\\";
////        Serializador serializar = new Serializador();
////        FileInputStream fin = null;
////        ObjectInputStream ois = null;
////
////        File diretorioMotoristas = new File(caminho);
////        File[] listarMotoristas = diretorioMotoristas.listFiles();
////
////        for (File selecionarDiretorio : listarMotoristas) {
////            try {
////                fin = new FileInputStream(selecionarDiretorio);
////                ois = new ObjectInputStream(fin);
////                motorista = (Motorista) ois.readObject();
////
////                if (motorista.getNomeMotorista() != null) {
////
////                    motorista.setStatusTrabalho(StatusMotorista.DISPONIVEL);
////                    serializar.serializarObjeto(motorista, caminho, motorista.getNumeroCnh());
////
////                }
////            } catch (Exception ex) {
////                System.out.println(ex.getMessage() + "\n");
////                System.err.println("Motorista não encontrado!");
////            } finally {
////                try {
////                    fin.close();
////                    ois.close();
////                } catch (IOException e) {
////                    System.out.println("Erro ao fechar arquivo");
////                }
////            }
////        }
////
////    }
//
//    //Método responsável por setar todos os veículos cadastrados como livres
////    public void setarStatusVeiculosLivres() {
////        Veiculo veiculo;
////        String caminho = "src\\arquivos\\veiculos\\";
////        Serializador serializar = new Serializador();
////        FileInputStream fin = null;
////        ObjectInputStream ois = null;
////
////        File diretorioVeiculos = new File(caminho);
////        File[] listarVeiculos = diretorioVeiculos.listFiles();
////
////        for (File selecionarDiretorio : listarVeiculos) {
////            try {
////                fin = new FileInputStream(selecionarDiretorio);
////                ois = new ObjectInputStream(fin);
////                veiculo = (Veiculo) ois.readObject();
////
////                if (veiculo.getPlacaVeiculo() != null) {
////
////                    veiculo.setStatusVeiculo(StatusVeiculo.LIVRE);
////                    serializar.serializarObjeto(veiculo, caminho, veiculo.getPlacaVeiculo());
////
////                }
////            } catch (Exception ex) {
////                System.out.println(ex.getMessage() + "\n");
////                System.err.println("Veículo não encontrado!");
////            } finally {
////                try {
////                    fin.close();
////                    ois.close();
////                } catch (IOException e) {
////                    System.out.println("Erro ao fechar arquivo");
////                }
////            }
////        }
////
////    }
//
//    //Método responsável por alterar o status da encomenda para ENTREGUE ou NAO ENTREGUE
//    public void alterarStatusFeedbackEncomenda(String codigo, int status) {
//        Encomenda encomenda;
//        String caminho = "src\\arquivos\\encomendas\\";
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//
//        File diretorioEncomendas = new File(caminho);
//        File[] listarEncomendas = diretorioEncomendas.listFiles();
//
//        for (File selecionarDiretorio : listarEncomendas) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                encomenda = (Encomenda) ois.readObject();
//
////                if (encomenda.getCodigoEncomenda().equals(codigo)) {
////
////                    if (status == 1){
////                        encomenda.setStatusEncomenda(ENTREGUE);
////                        serializar.serializarObjeto(encomenda, caminho, codigo);
////                    } else if (status == 2){
////                        encomenda.setStatusEncomenda(NAOENTREGUE);
////                        serializar.serializarObjeto(encomenda, caminho, codigo);
////                    }
////
////                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Encomenda não encontrada!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//
//    }
//
//    //Método responsável por setar todas as encomendas que estão com o status aguardando para pendentes
//    public void setarStatusEncomendasPendente() {
//        Encomenda encomenda;
//        String caminho = "src\\arquivos\\encomendas\\";
//        Serializador serializar = new Serializador();
//        FileInputStream fin = null;
//        ObjectInputStream ois = null;
//
//        File diretorioEncomendas = new File(caminho);
//        File[] listarEncomendas = diretorioEncomendas.listFiles();
//
//        for (File selecionarDiretorio : listarEncomendas) {
//            try {
//                fin = new FileInputStream(selecionarDiretorio);
//                ois = new ObjectInputStream(fin);
//                encomenda = (Encomenda) ois.readObject();
//
//                if (encomenda.getStatusEncomenda() == AGUARDANDO) {
//
//                    // encomenda.setStatusEncomenda(PENDENTE);
//                    //serializar.serializarObjeto(encomenda, caminho, encomenda.getCodigoEncomenda());
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage() + "\n");
//                System.err.println("Encomenda não encontrada!");
//            } finally {
//                try {
//                    fin.close();
//                    ois.close();
//                } catch (IOException e) {
//                    System.out.println("Erro ao fechar arquivo");
//                }
//            }
//        }
//
//    }
//
//    public boolean verificarCodigoEncomenda(int codigo) {
//        String codigoString = Integer.toString(codigo) + ".txt";
//        boolean resultado = false;
//        FileInputStream fin = null;
//        String caminho = "src\\arquivos\\encomendas\\";
//        File diretorioEncomendas = new File(caminho);
//        File[] listarMotoristas = diretorioEncomendas.listFiles();
//
//        for (File arquivo : listarMotoristas) {
//            if (arquivo.getName().equals(codigoString)) {
//                return true;
//            }
//        }
//        return resultado;
//    }
//
//    public boolean verificarCnhMotorista(String cnh) {
//        String cnhString = cnh + ".txt";
//        boolean resultado = false;
//        FileInputStream fin = null;
//        String caminho = "src\\arquivos\\motoristas\\";
//        File diretorioEncomendas = new File(caminho);
//        File[] listarMotoristas = diretorioEncomendas.listFiles();
//
//        for (File arquivo : listarMotoristas) {
//            if (arquivo.getName().equals(cnhString)) {
//                return true;
//            }
//        }
//        return resultado;
//    }
    
    
//    public Desserializador() {
//	}
//
//	@SuppressWarnings("unchecked")
//	public static <T> List<T> desserializar(String path, Class<T> clazz) throws Exception {
//		FileInputStream leitorByte = null;
//		ObjectInputStream leitorObjeto = null;
//
//		try {
//			leitorByte = new FileInputStream(path);
//			while (leitorByte.available() > 0) {
//				leitorObjeto = new ObjectInputStream(leitorByte);
//				List<T> obj = (List<T>) leitorObjeto.readObject();
//				return obj;
//			}
//		} catch (FileNotFoundException e) {
//			System.err.println(e);
//		} catch (EOFException e) {
//			System.err.println(e);
//		} catch (IOException e) {
//			System.err.println(e);
//		} catch (ClassNotFoundException e) {
//			System.err.println(e);
//		} finally {
//			try {
//				if (leitorObjeto != null) {
//					leitorObjeto.close();
//				}
//				if (leitorByte != null) {
//					leitorByte.close();
//				}
//			} catch (Exception e) {
//			}
//		}
//		return new ArrayList<>();
//	}

}

