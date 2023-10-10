import cv2
import pytesseract
import sys
from unidecode import unidecode
import re

# Função para pré-processamento da imagem (pode deixar vazia se não houver pré-processamento específico)
def preprocessamento(imagem):
    return imagem

# Obtém o caminho da imagem a partir dos argumentos da linha de comando
caminho_imagem = sys.argv[1]

# Lê a imagem
imagem = cv2.imread(caminho_imagem)

# Pré-processamento
imagem_preprocessada = preprocessamento(imagem)

# Configuração do caminho para o Tesseract-OCR
caminho_tesseract = r"C:\Program Files\Tesseract-OCR"
pytesseract.pytesseract.tesseract_cmd = caminho_tesseract + r"\tesseract.exe"

# Converte imagem em texto usando pytesseract
texto_temporario = pytesseract.image_to_string(imagem_preprocessada, config='--psm 6 -l por --oem 3')

# Converte caracteres especiais em ASCII aproximado usando unidecode
texto_corrigido = unidecode(texto_temporario)

# Padrões para encontrar CPF e datas
padrao_cpf = re.compile(r'\b\d{3}\.\d{3}\.\d{3}-\d{2}\b')
padrao_datas = re.compile(r'\b\d{1,2}/\d{1,2}/\d{2,4}\b')

# Busca por CPF e datas no texto
cpf_match = padrao_cpf.search(texto_corrigido)
datas = padrao_datas.findall(texto_corrigido)

# Organiza os dados em um dicionário
dados = {
    "CPF": cpf_match.group() if cpf_match else "N/A",
    "Data de Nascimento": datas[0] if datas else "N/A",
    "Data de Validade": datas[1] if len(datas) > 1 else "N/A",
    "Data de Origem": datas[2] if len(datas) > 2 else "N/A"
}

# Imprime os resultados de forma organizada
print("Resultados:")
for campo, valor in dados.items():
    print(f"{campo}: {valor}")
