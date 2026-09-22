# Local PDF Profiling & Markdown Extraction Pipeline

A fully local PDF processing pipeline for extracting **text, tables, figures, page structure, and Markdown** from technical PDF documents.

The pipeline uses **Docling** for document structure extraction and **PyMuPDF** for PDF rendering and figure cropping. It also generates profile and quality-assessment JSON files to help evaluate the extraction output.

## Features

* Fully offline/local processing
* PDF text extraction using Docling
* Table detection and Markdown table extraction
* Figure/picture detection and cropping
* Figure caption detection
* Figure duplicate detection
* Header/footer removal
* Text and figure overlap handling
* Page-level classification
* Markdown generation with local figure references
* Document profiling in JSON
* Basic Markdown quality assessment
* Page image rendering for visual verification
* Configurable PDF processing settings

## Pipeline

```text
PDF
 │
 ├── PyMuPDF
 │    └── Page rendering
 │
 └── Docling
      ├── Text extraction
      ├── Table detection
      └── Picture detection
             │
             ▼
      Region processing
      ├── BBox normalization
      ├── Figure/caption detection
      ├── Duplicate removal
      └── Text cleanup
             │
             ▼
      Output generation
      ├── Markdown
      ├── Cropped figures
      ├── Profile JSON
      ├── Page images
      └── Assessment JSON
```

## Project Structure

```text
project/
│
├── data/
│   └── raw_pdfs/
│       └── input.pdf
│
├── output/
│   ├── page_images/
│   ├── docling_profiles/
│   ├── markdown/
│   ├── cropped_images/
│   ├── assessments/
│   └── debug/
│
├── main.py
├── requirements.txt
└── README.md
```

## Requirements

* Python **3.10 or newer**
* Windows or Linux
* Internet is not required during execution when all required models/dependencies are already installed locally.
* Sufficient disk space for rendered pages and extracted figures.

## Installation

### 1. Clone the repository

```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Create a virtual environment

Windows:

```powershell
python -m venv .venv
.venv\Scripts\activate
```

Linux/macOS:

```bash
python3 -m venv .venv
source .venv/bin/activate
```

### 3. Install dependencies

```bash
pip install -r requirements.txt
```

If `requirements.txt` has not been created yet, install the required packages according to the versions used by the project.

### 4. Add PDF files

Place the input PDF files inside:

```text
data/raw_pdfs/
```

Example:

```text
data/raw_pdfs/
└── technical_document.pdf
```

## Running the Pipeline

Run:

```bash
python main.py
```

The script automatically processes all `.pdf` files inside `data/raw_pdfs/`.

## Output

For each PDF, the pipeline generates:

| Output              | Description                                        |
| ------------------- | -------------------------------------------------- |
| `markdown/`         | Clean Markdown representation of the document      |
| `docling_profiles/` | Detailed document structure and extraction profile |
| `cropped_images/`   | Extracted figure images                            |
| `page_images/`      | Rendered PDF pages                                 |
| `assessments/`      | Markdown quality and page-level assessment         |
| `debug/`            | Debug/inspection outputs when used                 |

### Profile JSON

The profile contains information such as:

* Document identifier
* File name and PDF path
* Number of pages
* Page dimensions
* Extracted text
* Tables
* Figures
* Page classifications
* Figure coordinates
* Figure captions

### Quality Assessment

The assessment checks basic extraction characteristics such as:

* Markdown length
* Header count
* Table rows
* HTML image tags
* Repeated characters
* Markdown-to-source-text ratio
* Possible dropped content
* Possible duplicated content

These checks are intended as **quality indicators**, not as a complete semantic evaluation of the extracted document.

## Offline Configuration

The pipeline is configured for local/offline execution using:

```python
os.environ["HF_HUB_OFFLINE"] = "1"
os.environ["TRANSFORMERS_OFFLINE"] = "1"
os.environ["HF_HUB_DISABLE_TELEMETRY"] = "1"
```

Docling remote services and external plugins are disabled in the PDF pipeline configuration.

## Notes

The pipeline preserves document information using bounding-box and provenance information provided by Docling. PyMuPDF is used where direct PDF-level rendering or image-region processing is required.

The generated Markdown uses standard Markdown image references for extracted figures rather than embedding HTML image tags.

## License

Add the appropriate project license here, for example:

```text
MIT License
```

if the repository is intended to be released under the MIT License.
