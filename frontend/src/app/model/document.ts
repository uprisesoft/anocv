export class Document {
    id: number | null;
    name: string;
    original: string;
    processed: string;

    constructor(document: Partial<Document> = {}) {
        this.id = document?.id || null;
        this.name = document?.name || '';
        this.original = document?.original || 'empty';
        this.processed = document?.processed || 'empty';
    }
}